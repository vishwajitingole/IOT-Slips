// Step 1: Create an abstract Pizza class with common methods for all pizzas
abstract class Pizza {
    String name;
    String dough;
    String sauce;

    // Step 2: Add common methods for preparing the pizza
    public abstract void prepare();

    public void bake() {
        System.out.println("Baking the pizza at 350 degrees.");
    }

    public void cut() {
        System.out.println("Cutting the pizza into slices.");
    }

    public void box() {
        System.out.println("Boxing the pizza.");
    }

    // Method to get the pizza name
    public String getName() {
        return name;
    }
}

// Step 3: Create concrete Pizza classes for different types of pizzas
class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "New York Style Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name + " with " + dough + " and " + sauce);
    }
}

class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Cheese Pizza";
        dough = "Thick Crust Dough";
        sauce = "Tomato Sauce";
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name + " with " + dough + " and " + sauce);
    }
}

// Step 4: Create a PizzaStore class that uses the factory method to order
// pizzas
abstract class PizzaStore {

    // Step 5: Create a method to order pizza and delegate creation to concrete
    // classes
    public Pizza orderPizza(String type) {
        Pizza pizza;

        // Create pizza using the factory method
        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    // Step 6: Define the abstract factory method
    protected abstract Pizza createPizza(String type);
}

// Step 7: Create concrete PizzaStore classes for different styles of pizza
// stores
class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else {
            return null; // You can add other types of pizza as needed
        }
    }
}

class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else {
            return null; // You can add other types of pizza as needed
        }
    }
}

// Step 8: Main class to demonstrate the Factory Method pattern
public class PizzaStoreDemo {
    public static void main(String[] args) {
        // Step 9: Create different pizza stores
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        // Step 10: Order pizzas from both stores
        System.out.println("Ordering a Cheese Pizza from NY Store:");
        Pizza pizza1 = nyStore.orderPizza("cheese");
        System.out.println("Ordered: " + pizza1.getName());

        System.out.println("\nOrdering a Cheese Pizza from Chicago Store:");
        Pizza pizza2 = chicagoStore.orderPizza("cheese");
        System.out.println("Ordered: " + pizza2.getName());
    }
}
