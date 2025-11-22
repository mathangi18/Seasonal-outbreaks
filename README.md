# Seasonal Outbreaks - Handover Documentation

## Overview
This repository contains the source code and resources for the Seasonal Outbreaks AnyLogic model. This package is prepared for AnyLogic Personal Learning Edition (PLE) 8.9.6.

## Documentation
The following documentation is available in the `Instructions/` folder:
*   `how_to_anylogic_help.html`
*   `ple_limits_and_guidelines.txt`
*   `features_master.txt`
*   `seasonal_outbreak_revised.docx`
*   `seasonal_outbreak_revised.txt`
*   `al_setup_instructions.txt`
*   `seasonaloutbreaks_al.zip`
*   `TEAM_HANDBOOK.txt`

**All documentation files are PRESENT.**

## Repository Structure
```
.
├── README.md                   # This file
├── Instructions/               # Documentation and Handover Files
├── snippets/                   # Code snippets for AnyLogic
├── resources/                  # Images and sounds
├── repo_validation/            # Validation scripts
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


