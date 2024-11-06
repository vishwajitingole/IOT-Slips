
// FlyBehavior Interface
interface FlyBehavior {
    void fly();
}

// QuackBehavior Interface
interface QuackBehavior {
    void quack();
}

// FlyBehavior ki do implementations
class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("Flying with wings!");
    }
}

class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("I can't fly!");
    }
}

// QuackBehavior ki do implementations
class Quack implements QuackBehavior {
    public void quack() {
        System.out.println("Quacking!");
    }
}

class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("<< Silence >>");
    }
}

// Duck class with behaviors
abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    // Constructor to initialize behaviors
    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    // Duck ko flying and quacking ka behavior dena
    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    // Other Duck-specific behavior (optional)
    public void swim() {
        System.out.println("All ducks float, even if they can't fly!");
    }

    // Setters for dynamically changing behaviors
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    // Abstract method for each specific duck
    public abstract void display();
}

class MallardDuck extends Duck {

    public MallardDuck() {
        super(new FlyWithWings(), new Quack());
    }

    public void display() {
        System.out.println("I am a Mallard Duck!");
    }
}

class ModelDuck extends Duck {

    public ModelDuck() {
        super(new FlyNoWay(), new MuteQuack());
    }

    public void display() {
        System.out.println("I am a Model Duck!");
    }
}

public class StrategyPatternDuckBehavior {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performFly();
        mallard.performQuack();

        System.out.println("\nChanging behavior...\n");

        Duck model = new ModelDuck();
        model.display();
        model.performFly();
        model.performQuack();

        // Change the behavior dynamically
        model.setFlyBehavior(new FlyWithWings());
        model.setQuackBehavior(new Quack());

        System.out.println("\nAfter changing behavior...\n");
        model.performFly();
        model.performQuack();
    }
}
