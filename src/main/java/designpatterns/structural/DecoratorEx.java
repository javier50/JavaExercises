/*
Core Idea
    Allows you to add responsibilities dynamically to objects without modifying their code.
    Achieved by wrapping the original object in a decorator class.

Java Implementation
    Component interface defines operations.
    Concrete component implements base behavior.
    Decorator wraps a component and adds new behavior.

Analogy:
Think of toppings on a pizza:
    Base pizza = concrete component.
    Cheese, olives, mushrooms = decorators.
    You can keep adding toppings without changing the original pizza recipe.
*/

package designpatterns.structural;

// Component interface
interface Coffee {
    String getDescription();
    double cost();
}

// Concrete component
class SimpleCoffee implements Coffee {
    public String getDescription() { return "Simple Coffee"; }
    public double cost() { return 5.0; }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;
    public CoffeeDecorator(Coffee coffee) { this.decoratedCoffee = coffee; }
    public String getDescription() { return decoratedCoffee.getDescription(); }
    public double cost() { return decoratedCoffee.cost(); }
}

// Concrete decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) { super(coffee); }
    public String getDescription() { return super.getDescription() + ", Milk"; }
    public double cost() { return super.cost() + 1.5; }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) { super(coffee); }
    public String getDescription() { return super.getDescription() + ", Sugar"; }
    public double cost() { return super.cost() + 0.5; }
}

public class DecoratorEx {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " $" + coffee.cost());

        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.cost());
    }
}
