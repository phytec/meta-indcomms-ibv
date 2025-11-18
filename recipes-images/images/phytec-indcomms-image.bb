require recipes-images/images/phytec-headless-image.bb

SUMMARY =  "This image is designed to show development of Industrial Communication firmware."

LICENSE = "MIT"

IMAGE_INSTALL += "\
	linux-ind-comms-demo \
	ibv-demo-firmware \
"
