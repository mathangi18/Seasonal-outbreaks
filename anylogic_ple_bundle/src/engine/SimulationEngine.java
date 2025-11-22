
import java.util.ArrayList;
import java.util.List;

public class SimulationEngine {
    public List<Patient> patients;
    public List<Facility> facilities;
    public double width;
    public double height;

    // Parameters
    public double infectionRadius = 20.0;
    public double infectionProb = 0.05;
    public double hospitalRange = 10.0;

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
        for (Patient p : patients) {
            if (p.hospitalized)
                continue;

            // 1. Movement
            if (p.infected && p.targetFacility != null) {
                // Move towards hospital
                double dx = p.targetFacility.x - p.x;
                double dy = p.targetFacility.y - p.y;
                double dist = Math.sqrt(dx * dx + dy * dy);

                if (dist < hospitalRange) {
                    // Arrived
                    if (p.targetFacility.currentPatients < p.targetFacility.capacity) {
                        p.hospitalized = true;
                        p.targetFacility.currentPatients++;
                        p.vx = 0;
                        p.vy = 0;
                    } else {
                        // Full, wait or find another (simple: wait)
                        p.vx = 0;
                        p.vy = 0;
                    }
                } else {
                    // Move towards
                    double speed = 2.0;
                    p.vx = (dx / dist) * speed;
                    p.vy = (dy / dist) * speed;
                    p.x += p.vx;
                    p.y += p.vy;
                }
            } else {
                // Random walk
                p.x += p.vx;
                p.y += p.vy;

                // Bounce
                if (p.x < 0 || p.x > width)
                    p.vx *= -1;
                if (p.y < 0 || p.y > height)
                    p.vy *= -1;
            }

            // 2. Infection Spread
            if (p.infected) {
                // Find nearest facility if not already targeting
                if (p.targetFacility == null) {
                    Facility best = null;
                    double minD = Double.MAX_VALUE;
                    for (Facility f : facilities) {
                        double d = ModelHelpers.distance(p.x, p.y, f.x, f.y);
                        if (d < minD && f.currentPatients < f.capacity) {
                            minD = d;
                            best = f;
                        }
                    }
                    p.targetFacility = best;
                }

                // Infect others
                for (Patient other : patients) {
                    if (!other.infected && !other.hospitalized) {
                        if (ModelHelpers.distance(p.x, p.y, other.x, other.y) < infectionRadius) {
                            if (ModelHelpers.coinFlip(infectionProb)) {
                                other.infected = true;
                            }
                        }
                    }
                }
            }
        }
    }

    public int getInfectedCount() {
        int count = 0;
        for (Patient p : patients)
            if (p.infected)
                count++;
        return count;
    }

    public int getHospitalizedCount() {
        int count = 0;
        for (Patient p : patients)
            if (p.hospitalized)
                count++;
        return count;
    }
}
