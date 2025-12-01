package designpatterns.creational;

/* Design pattern - FactoryMethod
 * Real-world usage:
 * - Building configuration objects (e.g., database connection settings).
 * - Constructing UI components with many optional parameters.
 * - Creating POS transactions with optional fields (discounts, taxes, payment methods).
 *
 * Key points:
 * - Product (Car) → the complex object being built.
 * - Builder (CarBuilder) → provides methods to set properties step by step.
 * - Fluent interface → each setter returns this, allowing chained calls.
 * - Client → calls the builder methods and finally build() to get the object.
 * */

// Product class
class Car {
    private String engine;
    private int wheels;
    private String color;

    // Private constructor to enforce building via Builder
    private Car(CarBuilder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.color = builder.color;
    }

    @Override
    public String toString() {
        return "Car [engine=" + engine + ", wheels=" + wheels + ", color=" + color + "]";
    }

    // Builder class
    public static class CarBuilder {
        private String engine;
        private int wheels;
        private String color;

        public CarBuilder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder setWheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}

// Client
public class BuilderEx {
    public static void main(String[] args) {
        // Build a sports car
        Car sportsCar = new Car.CarBuilder()
                .setEngine("V8")
                .setWheels(4)
                .setColor("Red")
                .build();

        // Build an economy car
        Car economyCar = new Car.CarBuilder()
                .setEngine("I4")
                .setWheels(4)
                .setColor("Blue")
                .build();

        System.out.println(sportsCar);
        System.out.println(economyCar);
    }
}

