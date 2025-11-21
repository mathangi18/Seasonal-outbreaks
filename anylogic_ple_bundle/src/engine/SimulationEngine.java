package engine;

import agents.Patient;
import agents.Facility;
import helpers.ModelHelpers;
import java.util.ArrayList;
import java.util.List;

public class SimulationEngine {
    public List<Patient> patients;
    public List<Facility> facilities;
    public double width;
    public double height;

    public SimulationEngine(double width, double height) {
        this.width = width;
        this.height = height;
        this.patients = new ArrayList<>();
        this.facilities = new ArrayList<>();
    }

    public void addPatient(Patient p) {
        patients.add(p);
    }

    public void addFacility(Facility f) {
        facilities.add(f);
    }

    public void step() {
        // Basic movement logic for demo purposes
        for (Patient p : patients) {
            if (!p.hospitalized) {
                p.x += p.vx;
                p.y += p.vy;
                
                // Bounce off walls
                if (p.x < 0 || p.x > width) p.vx *= -1;
                if (p.y < 0 || p.y > height) p.vy *= -1;
            }
        }
    }
}
