SUMMARY = "Test suite used to validate ACPICA"
HOMEPAGE = "http://www.acpica.org/"

LICENSE = "Intel"
LIC_FILES_CHKSUM = "file://tests/aapits/atexec.c;beginline=1;endline=115;md5=e92bcdfcd01d117d1bda3e814bb2030a"

DEPENDS = "bison flex"

SRC_URI = "https://acpica.org/sites/acpica/files/acpitests-unix-${PV}.tar.gz;name=acpitests \
           https://acpica.org/sites/acpica/files/acpica-unix2-${PV}.tar.gz;name=acpica \
           file://aapits-linux.patch \
           file://aapits-makefile.patch \
"
SRC_URI[acpitests.md5sum] = "067a3b96e5f8cc211aeb0444d135af8e"
SRC_URI[acpitests.sha256sum] = "ce67f8eba251e5d3470e90818efcb44e01ce563be94747049041fac417ac90f6"
SRC_URI[acpica.md5sum] = "44a36d5ac3faaaca4b0c0df6c14f9e93"
SRC_URI[acpica.sha256sum] = "63b4ac59a3a65833cae2c884eecb76e375d79b9af05a136eb804277a75695767"

S = "${WORKDIR}/acpitests-unix-${PV}"

EXTRA_OEMAKE = "'CC=${TARGET_PREFIX}gcc ${HOST_CC_ARCH} ${TOOLCHAIN_OPTIONS}' 'OPT_CFLAGS=-Wall'"

# The Makefiles expect a specific layout
do_compile() {
    cp -af ${WORKDIR}/acpica-unix2-${PV}/source ${S}
    cd tests/aapits
    oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -m0755 tests/aapits/bin/aapits ${D}${bindir}
}

COMPATIBLE_HOST = "(i.86|x86_64|arm|aarch64).*-linux"
