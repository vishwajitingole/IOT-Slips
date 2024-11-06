// Step 1: Create the Shape interface which will be implemented by Concrete Classes
interface Shape {
    void draw(); // Every shape will implement this draw method to perform drawing
}

// Step 2: Create Concrete Classes that implement the Shape interface
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle.");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle.");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square.");
    }
}

// Step 3: Create the Abstract Factory interface
interface ShapeFactory {
    Shape createShape(); // Each factory will create a specific type of shape
}

// Step 4: Create Concrete Factories that implement the ShapeFactory interface
class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle(); // This factory creates a Circle object
    }
}

class RectangleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Rectangle(); // This factory creates a Rectangle object
    }
}

class SquareFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Square(); // This factory creates a Square object
    }
}

// Step 5: Demonstrate the Abstract Factory Pattern in action
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        // Step 5.1: Create concrete factories
        ShapeFactory circleFactory = new CircleFactory();
        ShapeFactory rectangleFactory = new RectangleFactory();
        ShapeFactory squareFactory = new SquareFactory();

        // Step 5.2: Use the factories to create objects of different shapes
        Shape circle = circleFactory.createShape();
        Shape rectangle = rectangleFactory.createShape();
        Shape square = squareFactory.createShape();

        // Step 5.3: Draw the shapes
        circle.draw(); // Circle will be drawn
        rectangle.draw(); // Rectangle will be drawn
        square.draw(); // Square will be drawn
    }
}
