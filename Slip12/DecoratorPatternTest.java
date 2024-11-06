// Step 1: Car Interface
interface Car {
    void assemble();
}

// Step 2: Basic Car Implementation (Concrete Component)
class BasicCar implements Car {

    @Override
    public void assemble() {
        System.out.print("Basic Car.");
    }
}

// Step 3: Car Decorator (Abstract Decorator)
abstract class CarDecorator implements Car {
    protected Car decoratedCar;

    public CarDecorator(Car car) {
        this.decoratedCar = car;
    }

    public void assemble() {
        this.decoratedCar.assemble();
    }
}

// Step 4: Sports Car Decorator (Concrete Decorator)
class SportsCar extends CarDecorator {

    public SportsCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.print(" Adding features of Sports Car.");
    }
}

// Step 5: Luxury Car Decorator (Concrete Decorator)
class LuxuryCar extends CarDecorator {

    public LuxuryCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.print(" Adding features of Luxury Car.");
    }
}

// Step 6: Client Code to test the Decorator Pattern
public class DecoratorPatternTest {
    public static void main(String[] args) {
        Car sportsCar = new SportsCar(new BasicCar()); // Decorate BasicCar with SportsCar
        sportsCar.assemble();
        System.out.println("\n*****");

        Car sportsLuxuryCar = new LuxuryCar(new SportsCar(new BasicCar())); // Decorate BasicCar with SportsCar and
                                                                            // LuxuryCar
        sportsLuxuryCar.assemble();
    }
}
