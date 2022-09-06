package core;

// Abstract class
abstract class Animal {
    // Abstract method (does not have a body)
    public abstract void animalSound();
    // Regular method
    public void sleep() {
        System.out.println("Zzz");
    }
}

// Subclass (inherit from core.Animal)
class Pig extends Animal {
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The pig says: wee wee");
    }
}

class AbstractTest {
    public static void main(String[] args) {
        //core.Animal myObj = new core.Animal(); // will generate an error
        // 'core.Animal' is abstract; cannot be instantiated
        Pig myPig = new Pig(); // Create a core.Pig object
        myPig.animalSound();
        myPig.sleep();
    }
}