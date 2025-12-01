package designpatterns.creational;

/* Design pattern - FactoryMethod
 * Real-world usage:
 * - Document templates (clone a base template and customize).
 * - Game objects (clone enemies or items with similar properties).
 * - POS receipts (clone a standard receipt format and fill in transaction details).
 *
 * Key points:
 * - Prototype interface → declares the clone() method.
 * - Concrete class (Shape) → implements cloning logic.
 * - Client → uses clone() to create new objects without knowing the exact class.
 * - Result → cloned objects have the same data but are independent instances.
 * */

// Prototype interface
interface Prototype {
    Prototype clone();
}

// Concrete class implementing Prototype
class Shape implements Prototype {
    private String type;
    private String color;

    public Shape(String type, String color) {
        this.type = type;
        this.color = color;
    }

    // Implement clone method
    @Override
    public Prototype clone() {
        return new Shape(this.type, this.color);
    }

    @Override
    public String toString() {
        return "Shape [type=" + type + ", color=" + color + "]";
    }
}

// Client
public class PrototypeEx {
    public static void main(String[] args) {
        // Original object
        Shape circle = new Shape("Circle", "Red");

        // Clone object
        Shape clonedCircle = (Shape) circle.clone();

        System.out.println("Original: " + circle);
        System.out.println("Clone: " + clonedCircle);

        // Verify they are different objects
        System.out.println("Are they the same reference? " + (circle == clonedCircle));
    }
}
