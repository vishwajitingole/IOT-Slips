package Slip5;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

// EnumerationToIteratorAdapter class jo Iterator ko implement karti hai aur Enumeration ko adapt karti hai
class EnumerationToIteratorAdapter<T> implements Iterator<T> {
    private final Enumeration<T> enumeration; // Enumeration object ko store karte hain

    // Constructor jo Enumeration ko accept karta hai
    public EnumerationToIteratorAdapter(Enumeration<T> enumeration) {
        this.enumeration = enumeration;
    }

    // hasNext() method ko implement karte hain jo Enumeration ke hasMoreElements()
    // ko call karta hai
    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements(); // Agar aur elements hain toh true return karega
    }

    // next() method ko implement karte hain jo Enumeration ke nextElement() ko call
    // karta hai
    @Override
    public T next() {
        return enumeration.nextElement(); // Next element ko return karta hai
    }

    // remove() method optional hai Iterator mein, lekin Enumeration mein nahi hota
    // toh exception throw karega
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove not supported for Enumeration");
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        // Vector mein kuch elements add karte hain
        Vector<String> vector = new Vector<>();
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");

        // Enumeration ko Vector ke elements ke liye get karte hain
        Enumeration<String> enumeration = vector.elements();

        // Adapter banate hain jo Enumeration ko Iterator ke tarah behave karne dega
        Iterator<String> iterator = new EnumerationToIteratorAdapter<>(enumeration);

        // Ab hum Iterator ke tarah elements ko iterate kar sakte hain
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
