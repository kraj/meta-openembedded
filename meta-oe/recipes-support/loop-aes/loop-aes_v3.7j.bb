SUMMARY = "Loop-aes - replacement for loop driver that can do aes encryption"
DESCRIPTION = "Fast and transparent file system and swap encryption package for \
               linux. No source code changes to linux kernel. Works with 3.x,\
               2.6, 2.4, 2.2 and 2.0 kernels."
HOMEPAGE = "http://sourceforge.net/projects/loop-aes/"
LICENSE = "GPL-2.0"

LIC_FILES_CHKSUM = "file://aes-GPL.diff;md5=bf349af3486306c2e4d85de5b6fa3bb4"

SRC_URI = "http://loop-aes.sourceforge.net/loop-AES/loop-AES-${PV}.tar.bz2"
SRC_URI[md5sum] = "335238a7cfd45f157935c59156533a05"
SRC_URI[sha256sum] = "67ede839d4cac657359c39b05eac46f6991054768a7e1096bef5b92edb3b8aba"

inherit module

S = "${WORKDIR}/loop-AES-${PV}"

EXTRA_OEMAKE += "LINUX_SOURCE=${STAGING_KERNEL_DIR} INSTALL_MOD_PATH=${D} MODINST=n"

do_install () {
     install -D -m 0655 loop.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/misc/loop.ko
}
