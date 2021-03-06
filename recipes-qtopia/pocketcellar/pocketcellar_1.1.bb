DESCRIPTION = "Wine cellar manager. Allows you to record details of wines and \
those you have in your cellar. The Food Assistant will make suggestions of wines \
suitable for your meal, and indicate those in your cellar that match."
SECTION = "opie/applications"
LICENSE = "GPLv2+"
PR = "r3"

SRC_URI = "http://sources.openembedded.org/pocketcellar-1.1.tar.gz \
           file://winedb.patch \
           file://cellardb.patch \
           file://pocketcellar.patch \
           file://gcc3.patch"

inherit palmtop

EXTRA_QMAKEVARS_POST += " DESTDIR=pkg-cellar/home/QtPalmtop/bin/"

LIC_FILES_CHKSUM = "file://LICENSE;md5=7d7c232d655fd1c91af00d34b00de5df \
                    file://main.cpp;beginline=6;endline=17;md5=3d9b2857e2e23649cac285d9fbbbc9ca"

do_install() {
        install -d ${D}${palmtopdir}/bin \
        	   ${D}${palmtopdir}/apps/Applications \
        	   ${D}${palmtopdir}/pics \
		   ${D}${palmtopdir}/data/PocketCellar

	install -m 644 pkg-pcellar/home/QtPalmtop/data/PocketCellar/* ${D}${palmtopdir}/data/PocketCellar/
        install -m 755 pkg-cellar/home/QtPalmtop/bin/pocketcellar ${D}${palmtopdir}/bin/
        install -m 644 pocketcellar.desktop ${D}${palmtopdir}/apps/Applications/
        install -m 644 pocketcellar.png ${D}${palmtopdir}/pics/
        install -m 644 pkg-pcellar/home/root/Settings/foodassist.conf ${D}${palmtopdir}/data/PocketCellar/
}

FILES_${PN} = "/"

SRC_URI[md5sum] = "ef65260b37a0c11898c680a576846c94"
SRC_URI[sha256sum] = "5ae5e9816bc8503b768f831f058bd1c379bb821e8c0776015ffeb998e1d912f8"
