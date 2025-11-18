SUMMARY = "IBV/TI Industrial Communications demo firmware binaries"
LICENSE = "BSD-3-Clause & TI-TFL"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

PACKAGE_ARCH = "${MACHINE_ARCH}"

INSTALL_FW_DIR = "${nonarch_base_libdir}/firmware/ibv-indcomms"

SRC_URI = " \
    https://download.phytec.de/Software/Linux/BSP-Yocto-AM64x/resources/${BPN}-${PV}.tar.gz;subdir=${BPN} \
"
SRC_URI[sha256sum] = "a341a7a841d3d336034cfccc414bf7315eb5b6507bee47079b0916b54619a890"

S = "${WORKDIR}/${BPN}"

PV = "1.1"

do_install() {
    install -d ${D}${INSTALL_FW_DIR}
    cp -r ${S}/* ${D}${INSTALL_FW_DIR}
}

FILES:${PN} = " \
    ${INSTALL_FW_DIR} \
"

INSANE_SKIP += "arch"
