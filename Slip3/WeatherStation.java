import java.util.Observable;

// WeatherStation class jo Observable ka kaam karta hai
public class WeatherStation extends Observable {
    private float temperature; // Temperature ka data
    private float humidity; // Humidity ka data
    private float pressure; // Pressure ka data

    // Method to update temperature, humidity, pressure and notify observers
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged(); // Jab bhi data update ho, notify karega
    }

    // Notify karne ka method jab bhi data update ho
    public void measurementsChanged() {
        setChanged(); // Observable ke andar flag set karta hai ki data change ho gaya
        notifyObservers(); // Sab observers ko notify kar deta hai
    }

    // Temperature ko return karne ka method
    public float getTemperature() {
        return temperature;
    }

    // Humidity ko return karne ka method
    public float getHumidity() {
        return humidity;
    }

    // Pressure ko return karne ka method
    public float getPressure() {
        return pressure;
    }
}
