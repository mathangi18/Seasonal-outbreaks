#!/bin/bash
echo "Checking Environment..."

IMG_DIR="../resources/images"
IMAGES=("patient_doll.png" "hospital_small.png" "hospital_big.png" "ambulance.png")
ALL_FOUND=true

for img in "${IMAGES[@]}"; do
    if [ -f "$IMG_DIR/$img" ]; then
        echo "OK: $img found."
    else
        echo "FAIL: $img NOT found."
        ALL_FOUND=false
    fi
done

if $ALL_FOUND; then
    echo "Environment Validation PASSED."
else
    echo "Environment Validation FAILED."
fi
