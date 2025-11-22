# Quick Start & Handover Summary

## Immediate Actions
1.  **Install Prerequisites:** See `install_prereqs.md`. Ensure Java 8 and AnyLogic PLE 8.9.6 are installed.
2.  **Clone & Checkout:**
    ```bash
    git clone <repo-url>
    cd Seasonal-outbreaks
    git checkout handover/ag-handover-2025-11-22
    ```
3.  **Run Validation:**
    ```bash
    bash repo_validation/run_validation.sh
    ```
    Check `repo_validation/validation_report.txt` for "VERDICT: READY".

4.  **AnyLogic Setup:**
    *   Open AnyLogic PLE.
    *   Create a new model or open the existing `.alp` file (if present).
    *   **Copy Resources:** Copy `resources/images/` and `resources/sounds/` to your model's folder.
    *   **Paste Snippets:**
        *   `Main` agent -> Properties -> Advanced Java -> **Additional class code**: Paste content from `snippets/AdditionalClassCode.txt`.
        *   `Main` agent -> Agent Actions -> **On startup**: Paste content from `snippets/OnStartup.txt`.
        *   `Main` agent -> Agent Actions -> **On step**: Paste content from `snippets/OnStep.txt`.
    *   **Settings:** Set "On step" recurrence to **0.1 hours**.

## Handover Status
*   **Branch:** `handover/ag-handover-2025-11-22`
*   **Validation:** See `repo_validation/validation_report.txt`.
*   **Documentation:** See `README_FOR_TEAM.md` for detailed instructions.
