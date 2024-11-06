// Chicago style Pizza Store jo Chicago style pizza create kar raha hai
public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else {
            return null; // Future mein aur types add kar sakte hain
        }
    }
}
