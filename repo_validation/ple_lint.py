import os
import sys

def check_file(filepath):
    with open(filepath, 'r') as f:
        content = f.read()
    
    errors = []
    if "package " in content:
        errors.append("Found 'package ' declaration")
    if "import agents." in content:
        errors.append("Found 'import agents.'")
    if "import helpers." in content:
        errors.append("Found 'import helpers.'")
    if "import engine." in content:
        errors.append("Found 'import engine.'")
        
    return errors

files = [
    "anylogic_ple_bundle/src/agents/Patient.java",
    "anylogic_ple_bundle/src/agents/Facility.java",
    "anylogic_ple_bundle/src/helpers/ModelHelpers.java",
    "anylogic_ple_bundle/src/engine/SimulationEngine.java"
]

failed = False
for f in files:
    errs = check_file(f)
    if errs:
        print(f"FAIL: {f}")
        for e in errs:
            print(f"  - {e}")
        failed = True
    else:
        print(f"PASS: {f}")

if failed:
    sys.exit(1)
else:
    print("ALL LINT CHECKS PASSED")
