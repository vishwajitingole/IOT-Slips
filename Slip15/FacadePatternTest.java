// Step 1: Home Theater Components (Subsystems)

// Subsystem: Amplifier
class Amplifier {
    public void on() {
        System.out.println("Amplifier is ON"); // Amplifier ko on karte hain
    }

    public void off() {
        System.out.println("Amplifier is OFF"); // Amplifier ko off karte hain
    }

    public void setVolume(int level) {
        System.out.println("Amplifier volume set to " + level); // Volume set karte hain
    }
}

// Subsystem: DVD Player
class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is ON"); // DVD player ko on karte hain
    }

    public void off() {
        System.out.println("DVD Player is OFF"); // DVD player ko off karte hain
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie); // Movie play karte hain
    }

    public void stop() {
        System.out.println("DVD Player stopped"); // DVD player ko stop karte hain
    }
}

// Subsystem: Projector
class Projector {
    public void on() {
        System.out.println("Projector is ON"); // Projector ko on karte hain
    }

    public void off() {
        System.out.println("Projector is OFF"); // Projector ko off karte hain
    }

    public void setWideScreenMode() {
        System.out.println("Projector is in widescreen mode"); // Projector ko widescreen mode mein set karte hain
    }
}

// Subsystem: Lights
class Lights {
    public void dim(int level) {
        System.out.println("Lights dimmed to " + level + "%"); // Lights ko dim karte hain (brightness kam karte hain)
    }

    public void on() {
        System.out.println("Lights are ON"); // Lights ko on karte hain
    }
}

// Step 2: Facade Class to simplify the process
class HomeTheaterFacade {
    private Amplifier amplifier;
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private Lights lights;

    // Constructor that initializes all the subsystems
    public HomeTheaterFacade(Amplifier amplifier, DVDPlayer dvdPlayer, Projector projector, Lights lights) {
        this.amplifier = amplifier; // Amplifier ko initialize karte hain
        this.dvdPlayer = dvdPlayer; // DVD player ko initialize karte hain
        this.projector = projector; // Projector ko initialize karte hain
        this.lights = lights; // Lights ko initialize karte hain
    }

    // Method to start the movie (simplified interface)
    public void watchMovie(String movie) {
        System.out.println("\nGet ready to watch a movie..."); // Movie dekhne ki tayyari

        lights.dim(30); // Lights ko 30% dim karte hain (kam roshni)
        projector.on(); // Projector ko on karte hain
        projector.setWideScreenMode(); // Projector ko widescreen mode mein set karte hain
        amplifier.on(); // Amplifier ko on karte hain
        amplifier.setVolume(10); // Amplifier ki volume ko set karte hain (10 level)
        dvdPlayer.on(); // DVD player ko on karte hain
        dvdPlayer.play(movie); // Movie play karte hain
    }

    // Method to stop the movie (simplified interface)
    public void endMovie() {
        System.out.println("\nShutting down the movie..."); // Movie band kar rahe hain

        lights.on(); // Lights ko on karte hain
        projector.off(); // Projector ko off karte hain
        amplifier.off(); // Amplifier ko off karte hain
        dvdPlayer.stop(); // DVD player ko stop karte hain
        dvdPlayer.off(); // DVD player ko off karte hain
    }
}

// Step 3: Client Code to test the Facade Pattern
public class FacadePatternTest {
    public static void main(String[] args) {
        // Step 3.1: Creating instances of subsystems
        Amplifier amplifier = new Amplifier(); // Amplifier ka object banate hain
        DVDPlayer dvdPlayer = new DVDPlayer(); // DVD player ka object banate hain
        Projector projector = new Projector(); // Projector ka object banate hain
        Lights lights = new Lights(); // Lights ka object banate hain

        // Step 3.2: Creating the Facade object
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amplifier, dvdPlayer, projector, lights); // HomeTheaterFacade
                                                                                                        // ka object
                                                                                                        // banate hain

        // Step 3.3: Watching a movie
        homeTheater.watchMovie("Inception"); // Movie dekhte hain

        // Step 3.4: Ending the movie
        homeTheater.endMovie(); // Movie khatam karte hain
    }
}
