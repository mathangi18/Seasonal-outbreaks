import os
import csv

def run_test():
    print("Running Test Script...")
    
    # 1. Validate Images
    img_dir = os.path.join("..", "resources", "images")
    images = ["patient_doll.png", "hospital_small.png", "hospital_big.png", "ambulance.png"]
    missing = []
    
    for img in images:
        path = os.path.join(img_dir, img)
        if os.path.exists(path):
            print(f"OK: {img} found.")
        else:
            print(f"FAIL: {img} NOT found.")
            missing.append(img)
            
    if missing:
        print("Image validation FAILED.")
    else:
        print("Image validation PASSED.")

    # 2. Validate CSV Writing
    try:
        with open("test_output.csv", "w", newline='') as f:
            writer = csv.writer(f)
            writer.writerow(["Test", "Status"])
            writer.writerow(["ImageCheck", "Passed" if not missing else "Failed"])
        print("OK: CSV writing succeeded.")
    except Exception as e:
        print(f"FAIL: CSV writing failed: {e}")

if __name__ == "__main__":
    run_test()
