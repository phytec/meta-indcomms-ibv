FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

DT_SUBDIR = "ti"

SRC_URI:append = " \
	file://k3-am642-phyboard-electra-ind-eth-demo_icssg0.dtso;subdir=${DT_SUBDIR} \
	file://k3-am642-phyboard-electra-ind-eth-demo_icssg1.dtso;subdir=${DT_SUBDIR} \
	file://k3-am642-phyboard-electra-ind-eth-demo_r5f.dtso;subdir=${DT_SUBDIR} \
"

do_configure:prepend() {
	cp -r ${WORKDIR}/${DT_SUBDIR} ${S}/arch/arm64/boot/dts/
}

COMPATIBLE_MACHINE .= "|phyboard-electra-am64xx-2"
