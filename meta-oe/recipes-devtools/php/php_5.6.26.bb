require php.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=b602636d46a61c0ac0432bbf5c078fe4"

SRC_URI += "file://change-AC_TRY_RUN-to-AC_TRY_LINK.patch \
            file://pthread-check-threads-m4.patch \
           "
SRC_URI[md5sum] = "cb424b705cfb715fc04f499f8a8cf52e"
SRC_URI[sha256sum] = "d47aab8083a4284b905777e1b45dd7735adc53be827b29f896684750ac8b6236"

PNBLACKLIST[php] ?= "Fails to build with RSS http://errors.yoctoproject.org/Errors/Details/131630/ - the recipe will be removed on 2017-09-01 unless the issue is fixed"
