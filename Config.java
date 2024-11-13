/*
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static int rentalDuration;
    private static double lateFee;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("config.properties"));
            rentalDuration = Integer.parseInt(properties.getProperty("rentalDuration"));
            lateFee = Double.parseDouble(properties.getProperty("lateFee"));
        } catch (IOException e) {
            System.err.println("Error loading config: " + e.getMessage());
        }
    }

    public static int getRentalDuration() { return rentalDuration; }
    public static double getLateFee() { return lateFee; }

    public static void loadConfig() {
    }
}
*/
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

// Config.FilePaths cum fac astaaaa
public class Config {
    private static ConfigData configData;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            configData = mapper.readValue(new File("config.json"), ConfigData.class);
        } catch (IOException e) {
            System.err.println("Failed to load config: " + e.getMessage());
        }
    }

    public static int getRentalDuration() {
        return configData.getRentalConfig().getDurationDays();
    }

    public static double getLateFeePerDay() {
        return configData.getRentalConfig().getClass().getModifiers();
    }

    public static String getMoviesFilePath() {
        return configData.getFilePaths().getMoviesFilePath();
    }

    public static void loadConfig() {
    }

    // Additional getters as needed

    // Nested classes for JSON mapping
    public static class ConfigData {
        private RentalConfig rentalConfig;
        private FilePaths filePaths;
        private boolean loadSampleData;

        public Object getRentalConfig() {
            return rentalConfig;
        }
        Config FilePaths;
        public Config getFilePaths() {;

            return FilePaths;
        }

        // Getters and Setters
    }

    public static class RentalConfig {
        private int durationDays;
        private double lateFeePerDay;

        // Getters and Setters
    }

    public static class FilePaths {
        private String moviesFilePath;
        private String customersFilePath;
        private String rentalsFilePath;

        // Getters and Setters
    }
}
