SUMMARY = "Linux application for IndComms demo control and NVM-emulation"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

SRC_URI = " \
	https://download.phytec.de/Software/Linux/BSP-Yocto-AM64x/resources/linux_ind_comms_demo-${PV}.tar.gz;name=linux_ind_comms_demo \
	https://download.phytec.de/Software/Linux/BSP-Yocto-AM64x/resources/ibv_ind_comms_common-${PV}.tar.gz;name=ibv_ind_comms_common;subdir=ti_ind_comms_sdk_am64x \
"

SRC_URI[linux_ind_comms_demo.sha256sum] = "e0fa38082c88ce786b2ffce03afda03c117d5ae5d6f79a8bd082219acfe6c5ea"
SRC_URI[ibv_ind_comms_common.sha256sum] = "3ab8502b7b951b6c2943c688c0fca32ad276cc9c6b0a116dab385f6632d33e55"

S = "${WORKDIR}/linux_ind_comms_demo"

PV = "1.2"

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
