require ${PN}.inc

inherit opie_git
PR = "r1"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=development/keyview;name=first "
