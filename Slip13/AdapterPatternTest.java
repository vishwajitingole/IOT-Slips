// Step 1: Volt class to represent voltage
class Volt {
    private int volts;

    // Constructor to initialize the volts
    public Volt(int volts) {
        this.volts = volts;
    }

    // Getter method for volts
    public int getVolts() {
        return volts;
    }
}

// Step 2: Socket class that produces 120 volts (default voltage)
class Socket {

    // This method returns 120 volts by default
    public Volt getVolt() {
        return new Volt(120); // Default voltage 120V
    }
}

// Step 3: Adapter Class (Class Adapter Pattern)
// Adapter will extend Socket class and adapt the voltage to 3V, 12V, or default
// 120V
class SocketAdapter extends Socket {

    // This method adapts the voltage to 3V
    public Volt get3Volt() {
        Volt v = getVolt(); // Get the 120V from Socket
        return convertVolt(v, 40); // Convert it to 3V (120/40 = 3)
    }

    // This method adapts the voltage to 12V
    public Volt get12Volt() {
        Volt v = getVolt(); // Get the 120V from Socket
        return convertVolt(v, 10); // Convert it to 12V (120/10 = 12)
    }

    // This method converts voltage by dividing the given volt by the factor
    private Volt convertVolt(Volt v, int divisor) {
        return new Volt(v.getVolts() / divisor); // Return the new adapted voltage
    }
}

// Step 4: Client Code to test the Adapter pattern
public class AdapterPatternTest {
    public static void main(String[] args) {
        SocketAdapter socketAdapter = new SocketAdapter();

        // Get different voltages from the adapter
        Volt v3 = socketAdapter.get3Volt(); // Get 3V
        Volt v12 = socketAdapter.get12Volt(); // Get 12V
        Volt v120 = socketAdapter.getVolt(); // Get default 120V

        // Print the voltages
        System.out.println("Voltage converted to 3V: " + v3.getVolts() + "V");
        System.out.println("Voltage converted to 12V: " + v12.getVolts() + "V");
        System.out.println("Default voltage: " + v120.getVolts() + "V");
    }
}
