// New York style Pizza Store jo NY style pizza create kar raha hai
public class NyPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NyStyleCheesePizza();
        } else {
            return null; // Future mein aur types add kar sakte hain
        }
    }
}
