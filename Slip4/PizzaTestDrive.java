// Main class jo application ko test karega
public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NyPizzaStore(); // NY pizza store instance
        PizzaStore chicagoStore = new ChicagoPizzaStore(); // Chicago pizza store instance

        // NY cheese pizza order kar rahe hain
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ordered a " + pizza.getName() + "\n");

        // Chicago cheese pizza order kar rahe hain
        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Ordered a " + pizza.getName() + "\n");
    }
}
