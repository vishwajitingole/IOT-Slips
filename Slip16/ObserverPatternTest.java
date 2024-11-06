import java.util.*;

// Step 1: Create the Observer interface (Subscriber)
interface Observer {
    void update(String number); // Update method that will be called to update the observer with the new number
}

// Step 2: Create the Subject interface (Publisher)
interface Subject {
    void registerObserver(Observer observer); // To register a new observer

    void removeObserver(Observer observer); // To remove an observer

    void notifyObservers(); // Notify all observers when number changes
}

// Step 3: Concrete class that implements the Subject interface
class NumberConverter implements Subject {
    private List<Observer> observers; // List of observers that will be notified
    private String number; // The decimal number, which will be converted to other formats

    public NumberConverter() {
        observers = new ArrayList<>(); // Initializing observers list
    }

    public void setNumber(String number) {
        this.number = number; // Set the new number (decimal)
        notifyObservers(); // Notify all observers about the change in number
    }

    public String getNumber() {
        return this.number; // Return the current decimal number
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer); // Add new observer to the list
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer); // Remove observer from the list
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.number); // Notify each observer about the change in the number
        }
    }
}

// Step 4: Concrete Observer classes (For Hexadecimal, Octal, and Binary
// representations)
class HexadecimalObserver implements Observer {
    private Subject subject;

    public HexadecimalObserver(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this); // Registering this observer to the subject
    }

    @Override
    public void update(String number) {
        // Convert decimal to hexadecimal and display
        int decimal = Integer.parseInt(number);
        System.out.println("Hexadecimal: " + Integer.toHexString(decimal).toUpperCase());
    }
}

class OctalObserver implements Observer {
    private Subject subject;

    public OctalObserver(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this); // Registering this observer to the subject
    }

    @Override
    public void update(String number) {
        // Convert decimal to octal and display
        int decimal = Integer.parseInt(number);
        System.out.println("Octal: " + Integer.toOctalString(decimal));
    }
}

class BinaryObserver implements Observer {
    private Subject subject;

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this); // Registering this observer to the subject
    }

    @Override
    public void update(String number) {
        // Convert decimal to binary and display
        int decimal = Integer.parseInt(number);
        System.out.println("Binary: " + Integer.toBinaryString(decimal));
    }
}

// Step 5: Main class to demonstrate the Observer pattern
public class ObserverPatternTest {
    public static void main(String[] args) {
        // Step 5.1: Create the subject (NumberConverter) object
        NumberConverter numberConverter = new NumberConverter();

        // Step 5.2: Create observers for Hexadecimal, Octal, and Binary
        HexadecimalObserver hexObserver = new HexadecimalObserver(numberConverter);
        OctalObserver octObserver = new OctalObserver(numberConverter);
        BinaryObserver binObserver = new BinaryObserver(numberConverter);

        // Step 5.3: Change the number (Decimal), which will notify all observers
        System.out.println("Changing number to 25 (Decimal):");
        numberConverter.setNumber("25"); // Set new decimal number

        // Step 5.4: Change the number again
        System.out.println("\nChanging number to 50 (Decimal):");
        numberConverter.setNumber("50"); // Set new decimal number
    }
}
