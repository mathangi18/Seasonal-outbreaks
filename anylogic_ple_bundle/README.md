# AnyLogic PLE Code-First Visual Simulation Bundle

This bundle allows you to add visual elements to your AnyLogic simulation **without using the graphical editor** (Canvas, Presentation Palette, etc.). It uses Java reflection and code-only techniques to render patients, hospitals, and ambulances.

## Instructions

1.  **Open your AnyLogic Project.**
2.  **Select the `Main` agent.**
3.  **Paste the Code Snippets:**
    *   Copy the content of `anylogic_snippets/AdditionalClassCode.txt` and paste it into the **Additional Class Code** section of the Main agent.
    *   Copy the content of `anylogic_snippets/OnStartup.txt` and paste it into the **On Startup** action of the Main agent.
    *   Copy the content of `anylogic_snippets/OnStep.txt` and paste it into the **On Step** action of the Main agent (or create a recurring event that calls this code).

## How It Works

*   **Image Loading:** The code attempts to load images from `resources/images/`.
*   **Runtime Presentation:** It uses reflection to create `ShapeImage` objects at runtime and attach them to the presentation group.
*   **Fallback (Zero-UI):** If image loading or creation fails, it automatically enables a "Fallback Painter" that draws the simulation state directly onto the presentation root using `Graphics2D`, ensuring you always see the simulation.

## Files

*   `src/`: Java source code for the simulation logic (Patient, Facility, Engine).
*   `resources/images/`: Visual assets.
*   `anylogic_snippets/`: The code to paste into AnyLogic.
*   `tools/`: Validation scripts.

## Verification

Run `tools/validate_env.ps1` (Windows) or `tools/validate_env.sh` (Linux/Mac) to verify that all images and dependencies are present.
