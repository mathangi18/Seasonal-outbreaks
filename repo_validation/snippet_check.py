import os
import sys

def check_snippet(filepath):
    with open(filepath, 'r') as f:
        content = f.read()
    
    errors = []
    if "ShapeImage" in content:
        errors.append("Found 'ShapeImage' (Not allowed in minimal bundle)")
    if "Canvas" in content:
        errors.append("Found 'Canvas' (Not allowed in minimal bundle)")
    if "package " in content:
        errors.append("Found 'package ' declaration")
        
    return errors

files = [
    "anylogic_ple_bundle/anylogic_snippets/AdditionalClassCode.txt",
    "anylogic_ple_bundle/anylogic_snippets/OnStartup.txt",
    "anylogic_ple_bundle/anylogic_snippets/OnStep.txt"
]

failed = False
for f in files:
    errs = check_snippet(f)
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
    print("ALL SNIPPET CHECKS PASSED")
