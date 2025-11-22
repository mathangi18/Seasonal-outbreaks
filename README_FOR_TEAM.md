# Seasonal Outbreaks - Handover Documentation

## Overview
This repository contains the source code and resources for the Seasonal Outbreaks AnyLogic model. This package is prepared for AnyLogic Personal Learning Edition (PLE) 8.9.6.

## Repository Structure
```
.
├── README_FOR_TEAM.md          # This file
├── README_ACTION.txt           # Quick start checklist
├── install_prereqs.md          # Required software
├── handover_tasks.md           # Tasks for the next person
├── snippets/                   # Code snippets for AnyLogic
│   ├── AdditionalClassCode.txt
│   ├── OnStartup.txt
│   └── OnStep.txt
├── resources/                  # Images and sounds
│   ├── images/
│   └── sounds/
├── repo_validation/            # Validation scripts
│   ├── run_validation.py
│   ├── ple_lint.py
│   ├── snippet_check.py
│   └── validation_report.txt
└── src/                        # Java source files (reference)
```

## Getting Started

### 1. Prerequisites
Ensure you have the following installed:
*   **AnyLogic PLE 8.9.6**
*   **Java JDK 1.8**
*   **Git**
*   (Optional) Python 3

See `install_prereqs.md` for details.

### 2. Setup Instructions

1.  **Clone the Repository:**
    ```bash
    git clone <repo-url>
    cd Seasonal-outbreaks
    git checkout handover/ag-handover-2025-11-22
    ```

2.  **Run Validation:**
    Run the validation script to ensure the codebase is healthy and compatible.
    ```bash
    python repo_validation/run_validation.py
    ```
    Check `repo_validation/validation_report.txt`. It should say "Java compilation SUCCESS" and pass lint checks.

3.  **Open AnyLogic:**
    *   Launch AnyLogic PLE 8.9.6.
    *   Open your existing model file (`.alp`) or create a new one.

4.  **Import Resources:**
    *   Copy the contents of `resources/images/` and `resources/sounds/` into your model's folder (where the `.alp` file is located).
    *   In AnyLogic, refresh the project tree if necessary.

5.  **Apply Code Snippets:**
    You need to paste the code from the `snippets/` folder into the `Main` agent in AnyLogic.
    
    *   **Additional Class Code:**
        *   Open `snippets/AdditionalClassCode.txt`.
        *   In AnyLogic, select `Main`.
        *   Go to **Properties** -> **Advanced Java** -> **Additional class code**.
        *   Paste the content.
    
    *   **On Startup:**
        *   Open `snippets/OnStartup.txt`.
        *   In AnyLogic, select `Main`.
        *   Go to **Agent Actions** -> **On startup**.
        *   Paste the content.
    
    *   **On Step:**
        *   Open `snippets/OnStep.txt`.
        *   In AnyLogic, select `Main`.
        *   Go to **Agent Actions** -> **On step**.
        *   Paste the content.

6.  **Configure Settings:**
    *   Select `Main`.
    *   Go to **Agent Actions**.
    *   Ensure **On step** recurrence is enabled and set to **0.1 hours**.

### 3. Troubleshooting

If you encounter issues:

*   **Compilation Errors:** Check the `Problems` view in AnyLogic.
*   **Runtime Errors:** Check the `Console` view.
*   **Validation Failures:** Review `repo_validation/validation_report.txt`.

**Collecting Debug Info:**
If you need to report a bug, please provide:
1.  Screenshot of the `Problems` pane.
2.  Copy of the first 50 lines of the `Console` output.
3.  The `repo_validation/validation_report.txt` file.

## Contact
*   Primary: AG
*   Teammates: [Placeholders]
