DESCRIPTION = "PDA-Maze"
SECTION = "opie/games"
LICENSE = "GPLv2"
AUTHOR = "Bill Kendrick, Port by Rober Ernst"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-PDA-Maze.html"


SRC_URI = "http://sources.openembedded.org/pdamaze_V1.0.0.tar.gz \
           file://Makefile.patch"

S = "${WORKDIR}/pdamaze_V${PV}"

LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f \
                    file://Pdamaze.cpp;beginline=4;endline=12;md5=865e24c089f008b0e12624a42687cac4"

APPNAME = "pdamaze"
APPTYPE = "binary"
APPDESKTOP = "${S}"

do_compile_prepend() {
	oe_runmake -C images
}

do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/${APPNAME}/

}

inherit opie




SRC_URI[md5sum] = "bf27dd51fe03c8b475080b74de043a13"
SRC_URI[sha256sum] = "99d6bc6b360baabd6044e8883d467cc6ed7955f9ab66d8f87f61e3cc757fb97a"
