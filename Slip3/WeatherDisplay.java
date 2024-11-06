import java.util.Observable;
import java.util.Observer;

// WeatherDisplay class jo Observer ka kaam karta hai
public class WeatherDisplay implements Observer {
    private float temperature; // Displayed temperature
    private float humidity; // Displayed humidity
    private float pressure; // Displayed pressure
    private Observable observable;

    // Constructor jo observable object ko initialize karta hai
    public WeatherDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this); // Observer ko observable se register karna
    }

    // Jab bhi data update ho, ye update() method call hota hai
    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherStation) { // Check agar obs instance hai WeatherStation ka
            WeatherStation weatherStation = (WeatherStation) obs;
            this.temperature = weatherStation.getTemperature(); // Update temperature
            this.humidity = weatherStation.getHumidity(); // Update humidity
            this.pressure = weatherStation.getPressure(); // Update pressure
            display(); // Display method call karte hain to show updated data
        }
    }

    // Display method jo updated data ko print karta hai
    public void display() {
        System.out.println("Current conditions: " +
                "Temperature = " + temperature +
                ", Humidity = " + humidity +
                ", Pressure = " + pressure);
    }
}
