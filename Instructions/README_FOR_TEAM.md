# Seasonal Outbreaks - Team Instructions

## 1. Getting Started

### Download and Setup
1.  **Download:** Clone this repository or download the ZIP from the repository page.
2.  **Unzip:** If you downloaded a ZIP, extract it to a folder on your computer.
3.  **Open in AnyLogic:**
    *   Launch **AnyLogic PLE 8.9.6**.
    *   Click **Open** and navigate to the extracted folder.
    *   Select the `.alp` file (e.g., `Seasonal_outbreaks.alp` or similar inside the model folder).

### Syncing with Repo
To ensure you have the latest changes:
```bash
git pull origin main
```

## 2. Applying Code Snippets
The model logic relies on code snippets that must be pasted into the `Main` agent.

1.  **Locate Snippets:** Go to the `snippets/` folder in this repository.
2.  **Update Main Agent:**
    *   **Additional Class Code:**
        *   Copy content from `snippets/AdditionalClassCode.txt`.
        *   In AnyLogic: `Main` -> Properties -> **Advanced Java** -> **Additional class code**.
    *   **On Startup:**
        *   Copy content from `snippets/OnStartup.txt`.
        *   In AnyLogic: `Main` -> Agent Actions -> **On startup**.
    *   **On Step:**
        *   Copy content from `snippets/OnStep.txt`.
        *   In AnyLogic: `Main` -> Agent Actions -> **On step**.

## 3. Documentation
The following documentation is available in this folder (`Instructions/`):

*   `AnyLogic_Help.html` (Missing)
*   `PLE_Limits_and_Guidelines.txt` (Missing)
*   `Features_Master.txt` (Missing)
*   `SeasonalOutbreaks_Revised.docx` (Missing)
*   `AL_Setup_Instructions.txt` (Missing)

*Note: If these files are missing, please check with the project lead or previous handover package.*
