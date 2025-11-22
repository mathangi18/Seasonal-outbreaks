
public class Patient {
    public double x;
    public double y;
    public double vx;
    public double vy;
    public boolean infected;
    public boolean hospitalized;
    public Facility targetFacility;

    public Patient(double x, double y) {
        this.x = x;
        this.y = y;
        this.vx = 0;
        this.vy = 0;
        this.infected = false;
        this.hospitalized = false;
        this.targetFacility = null;
    }
}
