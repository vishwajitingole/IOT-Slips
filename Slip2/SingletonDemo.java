class Singleton {
    // Static instance variable jo sirf ek baar initialize hoga
    private static volatile Singleton instance = null;

    // Private constructor to restrict object creation from outside
    private Singleton() {
        System.out.println("Singleton instance created!");
    }

    // Public method to provide access to the single instance
    public static Singleton getInstance() {
        // Double-checked locking mechanism for thread safety
        if (instance == null) {
            synchronized (Singleton.class) { // Lock class level for thread-safe creation
                if (instance == null) {
                    instance = new Singleton(); // Instance create karte hain
                }
            }
        }
        return instance;
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        // Multiple threads create karte hain to test thread safety of Singleton
        Thread t1 = new Thread(() -> {
            Singleton s1 = Singleton.getInstance();
            System.out.println("Instance from Thread 1: " + s1);
        });

        Thread t2 = new Thread(() -> {
            Singleton s2 = Singleton.getInstance();
            System.out.println("Instance from Thread 2: " + s2);
        });

        t1.start();
        t2.start();
    }
}
