package helpers;

import java.util.Random;

public class ModelHelpers {
    private static final Random random = new Random();

    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double randomInRange(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }
    
    public static boolean coinFlip(double probability) {
        return random.nextDouble() < probability;
    }
}
