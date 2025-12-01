package designpatterns.creational;

/* Design pattern - FactoryMethod
 * Real-world usage:
 * - Payment systems (PaymentFactory → MercadoPagoFactory, StripeFactory)
 *   producing families of related objects
 *   (e.g., PaymentButton, PaymentForm).
 * - Cloud providers (CloudFactory → AWSFactory, GCPFactory)
 *   producing related services (e.g., StorageService, ComputeService).
 *
 * Key points:
 * - Abstract products (Button, Checkbox) → define the interfaces.
 * - Concrete products (WindowsButton, MacButton, etc.) → actual implementations.
 * - Abstract factory (GUIFactory) → declares methods to create products.
 * - Concrete factories (WindowsFactory, MacFactory) → produce families of related products.
 * - Client → works with the factory, not with concrete classes directly.
 * */

// Abstract product interfaces
interface Button {
    void paint();
}

interface Checkbox {
    void paint();
}

// Concrete products for Windows
class WindowsButton implements Button {
    public void paint() {
        System.out.println("Rendering a Windows-style button.");
    }
}

class WindowsCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Rendering a Windows-style checkbox.");
    }
}

// Concrete products for Mac
class MacButton implements Button {
    public void paint() {
        System.out.println("Rendering a Mac-style button.");
    }
}

class MacCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Rendering a Mac-style checkbox.");
    }
}

// Abstract factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete factories
class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// Client
public class AbstractFactoryEx {
    public static void main(String[] args) {
        // Choose factory dynamically
        GUIFactory factory;

        // Example: switch based on OS
        String os = "Windows"; // could be "Mac"

        if (os.equalsIgnoreCase("Windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        // Create products
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        // Use products
        button.paint();
        checkbox.paint();
    }
}

