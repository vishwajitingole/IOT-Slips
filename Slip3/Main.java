// Main class jo application ko run karta hai
public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation(); // WeatherStation ka instance banate hain
        WeatherDisplay display = new WeatherDisplay(weatherStation); // WeatherDisplay observer ko create aur register
                                                                     // karte hain

        // WeatherStation ke data update karke changes notify karte hain
        weatherStation.setMeasurements(25.3f, 65.2f, 1012.5f); // First update
        weatherStation.setMeasurements(27.8f, 60.0f, 1011.0f); // Second update
        weatherStation.setMeasurements(30.0f, 55.0f, 1009.0f); // Third update
    }
}
