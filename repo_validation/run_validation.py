import os
import subprocess
import sys
import glob

OUTPUT_FILE = "validation_report.txt"

def run_command(command, cwd=None):
    try:
        result = subprocess.run(command, cwd=cwd, shell=True, capture_output=True, text=True)
        return result.stdout + result.stderr, result.returncode
    except Exception as e:
        return str(e), 1

def main():
    with open(OUTPUT_FILE, "w") as f:
        f.write(f"Validation Report\n")
        f.write("========================================\n")

        # 1. Run PLE Lint
        f.write("Running PLE Lint...\n")
        print("Running PLE Lint...")
        lint_script = os.path.join("repo_validation", "ple_lint.py")
        if os.path.exists(lint_script):
            output, code = run_command(f"{sys.executable} {lint_script}")
            f.write(output)
        else:
            f.write(f"ERROR: {lint_script} not found.\n")
        f.write("========================================\n")

        # 2. Run Snippet Check
        f.write("Running Snippet Check...\n")
        print("Running Snippet Check...")
        snippet_script = os.path.join("repo_validation", "snippet_check.py")
        if os.path.exists(snippet_script):
            output, code = run_command(f"{sys.executable} {snippet_script}")
            f.write(output)
        else:
            f.write(f"ERROR: {snippet_script} not found.\n")
        f.write("========================================\n")

        # 3. Java Compilation Check
        f.write("Running Java Compilation Check...\n")
        print("Running Java Compilation Check...")
        java_files = []
        for root, dirs, files in os.walk("."):
            for file in files:
                if file.endswith(".java"):
                    java_files.append(os.path.join(root, file))
        
        if not java_files:
            f.write("No Java files found.\n")
        else:
            f.write("Compiling Java files...\n")
            version_out, _ = run_command("javac -version")
            f.write(version_out)
            
            # Compile all java files
            # We need to handle paths with spaces if any, though unlikely in this repo structure
            # subprocess.run with list of args is safer but we used shell=True above.
            # Let's construct the command carefully.
            # On Windows, we might hit command line length limits if too many files.
            # But here we have few.
            
            cmd = "javac " + " ".join(f'"{f}"' for f in java_files)
            output, code = run_command(cmd)
            f.write(output)
            
            if code == 0:
                f.write("Java compilation SUCCESS.\n")
            else:
                f.write("Java compilation FAILED.\n")
        f.write("========================================\n")
        f.write("Validation Complete.\n")

    print(f"Validation complete. See {OUTPUT_FILE}")

if __name__ == "__main__":
    main()
