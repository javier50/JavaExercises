/*
 Core Idea
   Defines a family of algorithms, encapsulates each one, and makes them interchangeable.
   The client can choose which algorithm to use at runtime.

 Java Implementation
   Strategy interface defines a method.
   Concrete strategies implement different versions of the method.
   Context class uses a strategy object.

 Analogy:
 Think of choosing a route in Google Maps:
   Strategies = driving, walking, cycling.
   Context = Google Maps app.
   You can switch strategies depending on your preference.
*/

package designpatterns.behavioral;

// Strategy interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete strategies
class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}
class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
}

// Context
class ShoppingCart {
    private PaymentStrategy strategy;
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    public void checkout(int amount) {
        strategy.pay(amount);
    }
}

public class StrategyEx {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(100);

        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(200);
    }
}
