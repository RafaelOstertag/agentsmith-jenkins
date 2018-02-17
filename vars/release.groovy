/**
 * Build dist tarball.
 */

/**
  * call `gmake distcheck`. It expects the directory `obj-default`
  *  to exists and being configure
  */
def checkDist() {
    stage("Check Dist") {
	try {			
	    dir("obj-default") {
		sh "gmake distcheck DISTCHECK_CONFIGURE_FLAGS='CFLAGS=-I/usr/local/include LDFLAGS=-L/usr/local/lib'"
	    }
	} catch (ex) {
	    echo "Granting write access after distcheck failure"
	    dir("obj-default") {
		sh "chmod -R u+w ."
	    }
	    throw ex
	}
    }
}

def makeDist() {
    stage("Make dist tarballs") {
	dir("obj-default") {
	    sh "gmake dist-gzip"
	    sh "gmake dist-bzip2"
	    sh "gmake dist-xz"
	}
    }
}

def isReleaseBranch() {
    return BRANCH_NAME.startsWith("release/")
}

def getRelease() {
    return BRANCH_NAME.split("/")[1]
}

def readVersionFromConfigureAc() {
    configureAc = readFile 'configure.ac'
    for (line in configureAc.split("\n") ) {
	if (line.startsWith("AC_INIT(") ) {
	    version = line
		.split(",")[1]
		.replace("[","")
		.replace("]","")
		.trim()
	    return version
	}
    }

    error "Unable to extract version from configure.ac"
}

def readPackageNameFromConfigureAc() {
    configureAc = readFile 'configure.ac'
    for (line in configureAc.split("\n") ) {
	if (line.startsWith("AC_INIT(") ) {
	    packageName = line
		.split(",")[0]
		.replace("AC_INIT([","")
		.replace("]","")
		.toLowerCase()
		.trim()
	    return packageName
	}
    }

    error "Unable to extract package name from configure.ac"
}

def releasePreflight() {
    stage("Release Preflight") {
	releaseVersion = getRelease()
	echo "Branch is version $releaseVersion"
	
	configureVersion = readVersionFromConfigureAc()
	echo "configure.ac is version $configureVersion"
	
	if (releaseVersion != configureVersion) {
	    error "Release version '$release' does not match the version '$configureVersion' in configure.ac"
	}
	echo "Release preflight ok"
    }
}

def publish() {
    stage("Publish") {
	packageName = readPackageNameFromConfigureAc()
	version = readVersionFromConfigureAc()
	dir("obj-default") {
	    sshagent(['16bce2a7-451d-4be5-82cb-68efab430517']) {
		// Eventhorizon only allows sftp
		sh """sftp agentsmith-deploy@eventhorizon.dmz.kruemel.home:/var/www/jails/www/usr/local/www/apache24/data/myapps/agentsmith/downloads <<EOF
put ${packageName}-${version}.tar.gz
put ${packageName}-${version}.tar.bz2
put ${packageName}-${version}.tar.xz
EOF
"""
	    }
	}
    }
}

def roll() {
    if (!isReleaseBranch()) {
    	echo "Not on release branch. Skipping."
	return
    }
    
    echo "On release branch. Going to roll release."
    releasePreflight()
    checkDist()
    makeDist()
    publish()
}
