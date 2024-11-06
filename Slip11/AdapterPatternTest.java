// The BeatModel interface jo pulse() method expect karta hai.
interface BeatModel {
    void pulse();
}

// HeartModel jisme beat() method hai.
class HeartModel {
    // Yeh woh method hai jo hume adapt karna hai.
    public void beat() {
        System.out.println("Heart is beating...");
    }
}

// Adapter class jo HeartModel ko BeatModel ke saath compatible banata hai
class HeartAdapter implements BeatModel {
    HeartModel heartModel;

    // Constructor mein HeartModel ka instance pass kiya jata hai
    public HeartAdapter(HeartModel heartModel) {
        this.heartModel = heartModel;
    }

    // Pulse() method jo BeatModel ko required hai, wo internally heartModel.beat()
    // ko call karega.
    @Override
    public void pulse() {
        heartModel.beat();
    }
}

// Client Code jo Adapter Pattern ko test karega
public class AdapterPatternTest {
    public static void main(String[] args) {
        // HeartModel ka instance banate hain
        HeartModel heart = new HeartModel();

        // HeartModel ko BeatModel ke compatible banane ke liye HeartAdapter use karte
        // hain
        BeatModel beatModel = new HeartAdapter(heart);

        // Pulse() method ko call karte hain jo internally heartModel.beat() ko call
        // karega
        System.out.println("Using adapted BeatModel:");
        beatModel.pulse(); // Yeh HeartModel ke beat() method ko call karega
    }
}
