package designpatterns.structural;

/* Design pattern - AdapterMethod
 * Real-world usage:
 * - Payment gateways (PaymentFactory → MercadoPago, Stripe, PayPal).
 * - Database connectors (ConnectionFactory → MySQL, PostgreSQL).
 * - UI components (ButtonFactory → WindowsButton, MacButton).
 *
 * Key points:
 * - Structural Pattern → It belongs to the structural category because
 *   it focuses on how classes and objects are composed.
 * - Purpose → Allows incompatible interfaces to work together by acting
 *   as a bridge.
 * - Roles:
 *   - Target → The interface the client expects.
 *   - Adaptee → The existing class with a different interface.
 *   - Adapter → Translates/adapts the Adaptee’s interface into the Target’s interface.
 * - Benefits:
 *   - Promotes reusability of existing code without modification.
 *   - Provides flexibility when integrating third-party or legacy systems.
 *   - Helps achieve loose coupling between components.
 * - Implementation styles:
 *   - Class Adapter → Uses inheritance (less common in Java due to single inheritance).
 *   - Object Adapter → Uses composition (preferred in Java).
 * */

// Step 1: Target interface (what the client expects)
interface TemperatureSensor {
    double getTemperatureInCelsius();
}

// Step 2: Adaptee (existing class with incompatible interface)
class FahrenheitSensor {
    public double getTemperatureInFahrenheit() {
        return 98.6; // Example value
    }
}

// Step 3: Adapter (bridge between Adaptee and Target)
class TemperatureAdapter implements TemperatureSensor {
    private FahrenheitSensor fahrenheitSensor;

    public TemperatureAdapter(FahrenheitSensor fahrenheitSensor) {
        this.fahrenheitSensor = fahrenheitSensor;
    }

    @Override
    public double getTemperatureInCelsius() {
        double f = fahrenheitSensor.getTemperatureInFahrenheit();
        return (f - 32) * 5 / 9; // Convert Fahrenheit to Celsius
    }
}

// Step 4: Client code
public class AdapterEx {
    public static void main(String[] args) {
        FahrenheitSensor legacySensor = new FahrenheitSensor();
        TemperatureSensor adapter = new TemperatureAdapter(legacySensor);

        System.out.println("Temperature in Celsius: " + adapter.getTemperatureInCelsius());
    }
}
