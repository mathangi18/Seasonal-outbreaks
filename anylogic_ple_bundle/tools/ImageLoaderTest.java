import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ImageLoaderTest {
    public static void main(String[] args) {
        File logFile = new File("../image_attempts.log");
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFile, true))) {
            writer.println("--- STARTING JAVA IMAGE LOADER TEST ---");

            String[] imageNames = { "patient_doll.png", "hospital_small.png", "hospital_big.png", "ambulance.png" };
            String[] paths = {
                    "../resources/images/",
                    "resources/images/",
                    "anylogic_ple_bundle/resources/images/",
                    "D:/Repos/Seasonal-outbreaks/anylogic_ple_bundle/resources/images/"
            };

            boolean allSuccess = true;

            for (String name : imageNames) {
                boolean found = false;
                for (String path : paths) {
                    File f = new File(path + name);
                    writer.println("Attempting to load: " + f.getAbsolutePath());
                    if (f.exists()) {
                        try {
                            BufferedImage img = ImageIO.read(f);
                            if (img != null) {
                                writer.println("SUCCESS: Loaded " + name + " (" + img.getWidth() + "x" + img.getHeight()
                                        + ")");
                                found = true;
                                break;
                            } else {
                                writer.println("FAIL: File exists but ImageIO returned null for " + name);
                            }
                        } catch (Exception e) {
                            writer.println("ERROR: Exception loading " + name + ": " + e.getMessage());
                        }
                    } else {
                        writer.println("FAIL: File not found at " + f.getAbsolutePath());
                    }
                }
                if (!found)
                    allSuccess = false;
            }

            if (allSuccess) {
                writer.println("VERDICT: IMAGES_WORKED");
                System.out.println("IMAGES_WORKED");
            } else {
                writer.println("VERDICT: FALLBACK_USED");
                System.out.println("FALLBACK_USED");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
