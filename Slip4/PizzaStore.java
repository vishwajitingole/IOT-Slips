// PizzaStore class jo pizza order aur banata hai
public abstract class PizzaStore {
    // Order method jo complete pizza banane ka process kar raha hai
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type); // Factory method call kar raha hai

        // Agar pizza create ho gaya to uska process karte hain
        if (pizza != null) {
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }
        return pizza;
    }

    // Factory method jo specific type of pizza create karta hai
    protected abstract Pizza createPizza(String type);
}
