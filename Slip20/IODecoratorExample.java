import java.io.*;

// Step 1: Create an abstract class that implements the Writer interface
abstract class WriterDecorator extends Writer {
    protected Writer writer;

    // Constructor to initialize the writer object
    public WriterDecorator(Writer writer) {
        this.writer = writer;
    }

    // Override the write method to delegate to the actual writer
    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        writer.write(cbuf, off, len);
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }

    @Override
    public void flush() throws IOException {
        writer.flush();
    }
}

// Step 2: Create a Concrete Decorator to convert uppercase letters to lowercase
class LowerCaseWriterDecorator extends WriterDecorator {

    // Constructor to pass the writer to the base class
    public LowerCaseWriterDecorator(Writer writer) {
        super(writer);
    }

    // Override the write method to convert to lowercase
    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        // Convert characters to lowercase before passing to the original writer
        for (int i = off; i < off + len; i++) {
            cbuf[i] = Character.toLowerCase(cbuf[i]);
        }
        writer.write(cbuf, off, len);
    }
}

// Step 3: Main class to test the functionality
public class IODecoratorExample {
    public static void main(String[] args) throws IOException {
        // Step 4: Create a StringWriter which is a concrete implementation of Writer
        StringWriter stringWriter = new StringWriter();

        // Step 5: Wrap the StringWriter with the LowerCaseWriterDecorator
        Writer lowerCaseWriter = new LowerCaseWriterDecorator(stringWriter);

        // Step 6: Use the decorator to write text
        lowerCaseWriter.write("HELLO WORLD!"); // This will be converted to lowercase
        lowerCaseWriter.flush(); // Ensure all data is written

        // Print the result after conversion to lowercase
        System.out.println(stringWriter.toString()); // Output: hello world!

        lowerCaseWriter.close(); // Close the writer
    }
}
