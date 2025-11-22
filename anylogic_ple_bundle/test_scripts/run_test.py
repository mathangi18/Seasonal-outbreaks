import os
import csv

def run_test():
    print("Running Test Script...")
    
    # 1. Validate Images
    # Fix: Use absolute path relative to this script to be safe
    script_dir = os.path.dirname(os.path.abspath(__file__))
    bundle_root = os.path.dirname(script_dir)
    img_dir = os.path.join(bundle_root, "resources", "images")
    
    print(f"Looking for images in: {img_dir}")
    
    images = ["patient_doll.png", "hospital_small.png", "hospital_big.png", "ambulance.png"]
    missing = []
    
    for img in images:
        path = os.path.join(img_dir, img)
        if os.path.exists(path):
            print(f"OK: {img} found.")
        else:
            print(f"FAIL: {img} NOT found at {path}")
            missing.append(img)
            
    if missing:
        print("Image validation FAILED.")
    else:
        print("Image validation PASSED.")

    # 2. Validate CSV Writing
    try:
        csv_path = os.path.join(bundle_root, "test_output.csv")
        with open(csv_path, "w", newline='') as f:
            writer = csv.writer(f)
            writer.writerow(["Test", "Status"])
            writer.writerow(["ImageCheck", "Passed" if not missing else "Failed"])
        print(f"OK: CSV writing succeeded at {csv_path}")
    except Exception as e:
        print(f"FAIL: CSV writing failed: {e}")

if __name__ == "__main__":
    run_test()
