SUMMARY = "Linux application for IndComms demo control and NVM-emulation"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

SRC_URI = " \
	https://download.phytec.de/Software/Linux/BSP-Yocto-AM64x/resources/linux_ind_comms_demo-${PV}.tar.gz;name=linux_ind_comms_demo \
	https://download.phytec.de/Software/Linux/BSP-Yocto-AM64x/resources/ibv_ind_comms_common-${PV}.tar.gz;name=ibv_ind_comms_common;subdir=ti_ind_comms_sdk_am64x \
"

SRC_URI[linux_ind_comms_demo.sha256sum] = "c243939836078a8247437af4e143c9e6d3794a580c01240b940f63ca1dc3fd1d"
SRC_URI[ibv_ind_comms_common.sha256sum] = "d46d8044af205c8c7b3d2f73578a9c75c30bb9d11c0652c88c1b58b8a0752903"

S = "${WORKDIR}/linux_ind_comms_demo"

PV = "1.1"

DEPENDS = "ti-rpmsg-char"
RDEPENDS:${PN} = "bash"

TARGET_CC_ARCH += "${LDFLAGS}"

EXAMPLE_TARGET_FOLDER = "${ROOT_HOME}/phytec_ibv_indcomms_example"

do_install() {
    install -d ${D}${EXAMPLE_TARGET_FOLDER}
    install -m 0755 ${S}/start-r5.sh            ${D}${EXAMPLE_TARGET_FOLDER}
    install -m 0755 ${S}/ind_comms_linux_demo   ${D}${EXAMPLE_TARGET_FOLDER}
}

FILES:${PN} = " \
    ${EXAMPLE_TARGET_FOLDER} \
"
