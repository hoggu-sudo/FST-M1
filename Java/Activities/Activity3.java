package activities;

public class Activity3 {

    public static String adjustDevice(String device, int value) {

        // Null safety check
        if (device == null) {
            return "Invalid device: null";
        }

        String status;

        switch (device) {
            case "THERMOSTAT":
                if (value >= 40) {
                    status = "[Thermostat] Warning: Temperature high.";
                } else {
                    status = "[Thermostat] Temperature is set to " + value + ".";
                }
                break;

            case "LIGHT":
                status = "[Light] Adjusting brightness to " + value + "%.";
                break;

            default:
                status = "Unknown device.";
        }

        return status;
    }

    public static void main(String[] args) {
        System.out.println(adjustDevice("THERMOSTAT", 45));
        System.out.println(adjustDevice("THERMOSTAT", 30));
        System.out.println(adjustDevice("LIGHT", 70));
        System.out.println(adjustDevice(null, 10));
    }
}
