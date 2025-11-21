
public class Facility {
    public double x;
    public double y;
    public String type; // "PHC" or "Private"
    public int capacity;
    public int currentPatients;

    public Facility(double x, double y, String type, int capacity) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.capacity = capacity;
        this.currentPatients = 0;
    }
}
