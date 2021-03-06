// Build profiles used on various operating systems.

/**
 * The general format is:
 *
 * // ...
 * "<OS>": [
 *    "<PROFILE>" : [
 *       "env" : [ ]
 *       "flags" : []
 *    ]
 * ]
 *
 * Where `<OS>` is the operating system name which is passed to
 * `agentsmith.build()`. `<PROFILE>` is the profile name. 
 *
 * `"env"` contains environment variables passed to the configure
 * shell script and make. It must contain 'MAKE=', since it's
 * existence is assumed by the stages called in `agentsmith.build()`.
 *
 * `"flags"` are passed as command line arguments to the configure
 * shell script.
 */

@groovy.transform.Field
profiles = [
    //
    // Solaris
    //
    "Solaris": [
	"default" : [
	    "env": [
		"CC=cc",
		"CXX=CC",
		"LDFLAGS=",
		"CFLAGS=",
		"CXXFLAGS=",
		"MAKE=gmake"
	    ],
	    "flags": [
		"--disable-silent-rules",
		"--enable-debug"
	    ],
	    "makeflags": [
	    ]
	    
	]
    ],
    //
    // Linux
    //
    "Linux": [
	"default" : [
	    "env": [
		"CC=cc",
		"CXX=c++",
		"CPP=cpp",
		"LDFLAGS=",
		"CFLAGS=",
		"CXXFLAGS=",
		"MAKE=make"
	    ],
	    "flags": [
		"--disable-silent-rules",
		"--enable-debug"
	    ],
	    "makeflags": [
		"CFLAGS='-Wall -pedantic -Werror'"
	    ]
	]
    ],
    //
    // OpenBSD
    //
    "OpenBSD": [
	"default" : [
	    "env": [
		"CC=cc",
		"CXX=c++",
		"CPP=cpp",
		"LDFLAGS=-L/usr/local/lib -Wl,--rpath -Wl,/usr/local/lib",
		"CPPFLAGS=-I/usr/local/include",
		"CFLAGS=",
		"CXXFLAGS=",
		"MAKE=gmake",
		"AUTOCONF_VERSION=2.69",
		"AUTOMAKE_VERSION=1.15"
	    ],
	    "flags": [
		"--disable-silent-rules",
		"--enable-debug"
	    ],
	    "makeflags": [
		"CFLAGS='-Wall -pedantic -Werror'"
	    ]
	]
    ],
    //
    // NetBSD
    //
    "NetBSD": [
	"default" : [
	    "env": [
		"CC=cc",
		"CXX=c++",
		"CPP=cpp",
		"LDFLAGS=-L/usr/pkg/lib -Wl,--rpath -Wl,/usr/pkg/lib",
		"CFLAGS=",
		"CPPFLAGS=-I/usr/pkg/include",
		"CXXFLAGS=",
		"MAKE=gmake"
	    ],
	    "flags": [
		"--disable-silent-rules",
		"--enable-debug"
	    ],
	    "makeflags": [
		"CFLAGS='-Wall -pedantic -Werror'"
	    ]
	]
    ],
    //
    // FreeBSD
    //
    "FreeBSD": [
	"default" : [
	    "env": [
		"CC=cc",
		"CXX=c++",
		"CPP=cpp",
		"LDFLAGS=-L/usr/local/lib -Wl,--rpath -Wl,/usr/local/lib",
		"CPPFLAGS=-I/usr/local/include",
		"CFLAGS=",
		"CXXFLAGS=",
		"MAKE=gmake"
	    ],
	    "flags": [
		"--disable-silent-rules",
		"--enable-debug"
	    ],
	    "makeflags": [
		"CFLAGS='-Wall -pedantic -Werror'"
	    ]
	],
	"fb-clang60-ports" : [
	    "env": [
		"CC=clang60",
		"CXX=clang++60",
		"CPP=clang-cpp60",
		"LDFLAGS=-L/usr/local/llvm60/lib -Wl,-rpath -Wl,/usr/local/llvm60/lib -L/usr/local/lib -Wl,--rpath -Wl,/usr/local/lib",
		"CPPFLAGS=-I/usr/local/include",
		"CFLAGS=",
		"CXXFLAGS=",
		"MAKE=gmake"
	    ],
	    "flags": [
		"--disable-silent-rules",
		"--enable-debug"
	    ],
	    "makeflags": [
		"CFLAGS='-Wall -pedantic -Werror'"
	    ]
	],
	"fb-clang50-ports" : [
	    "env": [
		"CC=clang50",
		"CXX=clang++50",
		"CPP=clang-cpp50",
		"LDFLAGS=-L/usr/local/llvm50/lib -Wl,-rpath -Wl,/usr/local/llvm50/lib -L/usr/local/lib -Wl,--rpath -Wl,/usr/local/lib",
		"CPPFLAGS=-I/usr/local/include",
		"CFLAGS=",
		"CXXFLAGS=",
		"MAKE=gmake"
	    ],
	    "flags": [
		"--disable-silent-rules",
		"--enable-debug"
	    ],
	    "makeflags": [
		"CFLAGS='-Wall -pedantic -Werror'"
	    ]
	],
	"fb-clang34-ports" : [
	    "env": [
		"CC=clang34",
		"CXX=clang++34",
		"CPP=clang-cpp34",
		"LDFLAGS=-L/usr/local/llvm34/lib -Wl,-rpath -Wl,/usr/local/llvm34/lib -L/usr/local/lib -Wl,--rpath -Wl,/usr/local/lib",
		"CPPFLAGS=-I/usr/local/include",
		"CFLAGS=",
		"CXXFLAGS=",
		"MAKE=gmake"
	    ],
	    "flags": [
		"--disable-silent-rules",
		"--enable-debug"
	    ],
	    "makeflags": [
		"CFLAGS='-Wall -pedantic -Werror'"
	    ]
	],
	"fb-clang35-ports" : [
	    "env": [
		"CC=clang35",
		"CXX=clang++35",
		"CPP=clang-cpp35",
		"LDFLAGS=-L/usr/local/llvm35/lib -Wl,-rpath -Wl,/usr/local/llvm35/lib -L/usr/local/lib -Wl,--rpath -Wl,/usr/local/lib",
		"CPPFLAGS=-I/usr/local/include",
		"CFLAGS=",
		"CXXFLAGS=",
		"MAKE=gmake"
	    ],
	    "flags": [
		"--disable-silent-rules",
		"--enable-debug"
	    ],
	    "makeflags": [
		"CFLAGS='-Wall -pedantic -Werror'"
	    ]
	],
	"fb-clang38-ports" : [
	    "env": [
		"CC=clang38",
		"CXX=clang++38",
		"CPP=clang-cpp38",
		"LDFLAGS=-L/usr/local/llvm38/lib -Wl,-rpath -Wl,/usr/local/llvm38/lib -L/usr/local/lib -Wl,--rpath -Wl,/usr/local/lib",
		"CPPFLAGS=-I/usr/local/include",
		"CFLAGS=",
		"CXXFLAGS=",
		"MAKE=gmake"
	    ],
	    "flags": [
		"--disable-silent-rules",
		"--enable-debug"
	    ],
	    "makeflags": [
		"CFLAGS='-Wall -pedantic -Werror'"
	    ]
	],
	"fb-gcc47-ports" : [
	    "env": [
		"CC=gcc47",
		"CXX=g++47",
		"CPP=cpp47",
		"LDFLAGS=-L/usr/local/lib/gcc47 -Wl,-rpath -Wl,/usr/local/lib/gcc47 -L/usr/local/lib -Wl,--rpath -Wl,/usr/local/lib",
		"CPPFLAGS=-I/usr/local/include",
		"CFLAGS=",
		"CXXFLAGS=",
		"MAKE=gmake"
	    ],
	    "flags": [
		"--disable-silent-rules",
		"--enable-debug"
	    ],
	    "makeflags": [
		"CFLAGS='-Wall -pedantic -Werror'"
	    ]
	],
	"fb-gcc48-ports" : [
	    "env": [
		"CC=gcc48",
		"CXX=g++48",
		"CPP=cpp48",
		"LDFLAGS=-L/usr/local/lib/gcc48 -Wl,-rpath -Wl,/usr/local/lib/gcc48 -L/usr/local/lib -Wl,--rpath -Wl,/usr/local/lib",
		"CPPFLAGS=-I/usr/local/include",
		"CFLAGS=",
		"CXXFLAGS=",
		"MAKE=gmake"
	    ],
	    "flags": [
		"--disable-silent-rules",
		"--enable-debug"
	    ],
	    "makeflags": [
		"CFLAGS='-Wall -pedantic -Werror'"
	    ]
	],
	"fb-gcc49-ports" : [
	    "env": [
		"CC=gcc49",
		"CXX=g++49",
		"CPP=cpp49",
		"LDFLAGS=-L/usr/local/lib/gcc49 -Wl,-rpath -Wl,/usr/local/lib/gcc49 -L/usr/local/lib -Wl,--rpath -Wl,/usr/local/lib",
		"CPPFLAGS=-I/usr/local/include",
		"CFLAGS=",
		"CXXFLAGS=",
		"MAKE=gmake"
	    ],
	    "flags": [
		"--disable-silent-rules",
		"--enable-debug"
	    ],
	    "makeflags": [
		"CFLAGS='-Wall -pedantic -Werror'"
	    ]
	],
	"fb-gcc5-ports" : [
	    "env": [
		"CC=gcc5",
		"CXX=g++5",
		"CPP=cpp5",
		"LDFLAGS=-L/usr/local/lib/gcc5 -Wl,-rpath -Wl,/usr/local/lib/gcc5 -L/usr/local/lib -Wl,--rpath -Wl,/usr/local/lib",
		"CPPFLAGS=-I/usr/local/include",
		"CFLAGS=",
		"CXXFLAGS=",
		"MAKE=gmake"
	    ],
	    "flags": [
		"--disable-silent-rules",
		"--enable-debug"
	    ],
	    "makeflags": [
		"CFLAGS='-Wall -pedantic -Werror'"
	    ]
	],
	"fb-gcc6-ports" : [
	    "env": [
		"CC=gcc6",
		"CXX=g++6",
		"CPP=cpp6",
		"LDFLAGS=-L/usr/local/lib/gcc6 -Wl,-rpath -Wl,/usr/local/lib/gcc6 -L/usr/local/lib -Wl,--rpath -Wl,/usr/local/lib",
		"CPPFLAGS=-I/usr/local/include",
		"CFLAGS=",
		"CXXFLAGS=",
		"MAKE=gmake"
	    ],
	    "flags": [
		"--disable-silent-rules",
		"--enable-debug"
	    ],
	    "makeflags": [
		"CFLAGS='-Wall -pedantic -Werror'"
	    ]
	],
	"fb-gcc7-ports" : [
	    "env": [
		"CC=gcc7",
		"CXX=g++7",
		"CPP=cpp7",
		"LDFLAGS=-L/usr/local/lib/gcc7 -Wl,-rpath -Wl,/usr/local/lib/gcc7 -L/usr/local/lib -Wl,--rpath -Wl,/usr/local/lib",
		"CPPFLAGS=-I/usr/local/include",
		"CFLAGS=",
		"CXXFLAGS=",
		"MAKE=gmake"
	    ],
	    "flags": [
		"--disable-silent-rules",
		"--enable-debug"
	    ],
	    "makeflags": [
		"CFLAGS='-Wall -pedantic -Werror'"
	    ]
	]
    ]
]
