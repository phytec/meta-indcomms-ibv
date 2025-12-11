SUMMARY = "IBV/TI Industrial Communications demo firmware binaries"
LICENSE = "BSD-3-Clause & TI-TFL"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

PACKAGE_ARCH = "${MACHINE_ARCH}"

INSTALL_FW_DIR = "${nonarch_base_libdir}/firmware/ibv-indcomms"

SRC_URI = " \
    https://download.phytec.de/Software/Linux/BSP-Yocto-AM64x/resources/${BPN}-${PV}.tar.gz;subdir=${BPN} \
"
SRC_URI[sha256sum] = "3e96b787838cc7b7216f84f0cb3b57521a8cfbf756da93385aa0f5cda66e9528"

RCONFLICTS:${PN} = "mcu-plus-sdk-firmware"
RREPLACES:${PN} = "mcu-plus-sdk-firmware"

S = "${WORKDIR}/${BPN}"

PV = "1.2"

do_install() {
    install -d ${D}${INSTALL_FW_DIR}
    cp -r ${S}/* ${D}${INSTALL_FW_DIR}
}

FILES:${PN} = " \
    ${INSTALL_FW_DIR} \
"

INSANE_SKIP += "arch"
