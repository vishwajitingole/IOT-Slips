import java.io.BufferedReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

// LowerCaseReader class banayi hai jo FilterReader ko extend karti hai
// Yeh har character ko lowercase mein convert karega jab read hoga
class LowerCaseReader extends FilterReader {
    // Constructor jo FilterReader ko initialize karta hai
    protected LowerCaseReader(Reader in) {
        super(in);
    }

    // `read()` method ko override karte hain
    // Har character ko lowercase mein convert karke return karta hai
    @Override
    public int read() throws IOException {
        int c = super.read(); // Character read karte hain
        return (c == -1) ? c : Character.toLowerCase((char) c); // Agar uppercase hai toh lowercase mein convert
    }
}

public class Decorator {
    public static void main(String[] args) {
        System.out.println("Enter text (uppercase will convert to lowercase). Type 'exit' to stop:");

        // BufferedReader ke saath hum LowerCaseReader ko wrap karte hain
        // Yeh automatically uppercase letters ko lowercase mein badal dega
        try (BufferedReader reader = new BufferedReader(new LowerCaseReader(new InputStreamReader(System.in)))) {
            String line;
            // Jab tak user `exit` nahi likhta, har line ko read karte hain aur display
            // karte hain
            while ((line = reader.readLine()) != null && !line.equalsIgnoreCase("exit")) {
                System.out.println(line); // Lowercase mein converted line ko display karte hain
            }
        } catch (IOException e) {
            e.printStackTrace(); // Agar koi error aayi toh usko print karenge
        }
    }
}
