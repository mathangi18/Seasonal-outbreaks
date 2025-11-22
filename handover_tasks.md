# Handover Tasks for Team

Please follow this checklist to complete the handover process:

1.  [ ] **Run Validation:** Execute `bash repo_validation/run_validation.sh` and confirm all checks pass.
2.  [ ] **Load Model:** Open the model in AnyLogic PLE 8.9.6.
3.  [ ] **Apply Snippets:**
    *   [ ] Paste `snippets/AdditionalClassCode.txt` into Main -> Additional class code.
    *   [ ] Paste `snippets/OnStartup.txt` into Main -> On startup.
    *   [ ] Paste `snippets/OnStep.txt` into Main -> On step.
4.  [ ] **Configure Settings:**
    *   [ ] Set "On step" recurrence to `0.1 hours`.
    *   [ ] Verify resource paths (images/sounds).
5.  [ ] **Run Experiment:** Run the "Simulation" experiment.
6.  [ ] **Verify Output:**
    *   [ ] Check Console for "ON STARTUP complete".
    *   [ ] Check for visible patients/scoreboard.
    *   [ ] Take a screenshot of the "Problems" pane if there are any errors.
