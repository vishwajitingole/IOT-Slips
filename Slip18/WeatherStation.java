import java.util.Observable;
import java.util.Observer;

// Step 1: Create the WeatherData class which extends Observable
class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    // Step 2: Method to set measurements
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged(); // Notify observers when measurements change
    }

    // Step 3: Method to notify observers that measurements have changed
    public void measurementsChanged() {
        setChanged(); // Marks this Observable as changed
        notifyObservers(); // Notifies all registered observers
    }

    // Step 4: Getter methods for weather data
    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}

// Step 5: Create the CurrentConditionsDisplay class which implements Observer
class CurrentConditionsDisplay implements Observer {
    private float temperature;
    private float humidity;
    private float pressure;

    // Step 6: This method will be called when WeatherData changes
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
            display(); // Display updated weather information
        }
    }

    // Step 7: Method to display the current conditions
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees, " + humidity + "% humidity, " + pressure
                + " pressure");
    }
}

// Step 8: Main class to run the program
public class WeatherStation {
    public static void main(String[] args) {
        // Step 9: Create WeatherData and Observer (CurrentConditionsDisplay)
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();

        // Step 10: Register the observer
        weatherData.addObserver(currentDisplay);

        // Step 11: Simulate data changes
        System.out.println("First Measurement:");
        weatherData.setMeasurements(80, 65, 30.4f); // Setting new weather data

        System.out.println("\nSecond Measurement:");
        weatherData.setMeasurements(82, 70, 29.8f); // Another data change

        System.out.println("\nThird Measurement:");
        weatherData.setMeasurements(78, 90, 29.2f); // Another data change
    }
}
