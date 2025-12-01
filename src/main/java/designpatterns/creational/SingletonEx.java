package designpatterns.creational;

/* Design pattern - SingletonEx
 * Real-world usage:
 * - Database connection manager
 * - Logger utility
 * - Configuration manager
 *
 * Key points:
 * - Private constructor → prevents direct instantiation with new.
 * - Static instance → holds the single object.
 * - Lazy initialization → object is created only when first requested.
 * - Global access → getInstance() provides the same object every time.
 * */

public class SingletonEx {

    // Private static variable that holds the single instance
    private static SingletonEx instance;

    // Private constructor prevents instantiation from outside
    private SingletonEx() {
        System.out.println("SingletonEx instance created.");
    }

    // Public method to provide access to the instance
    public static SingletonEx getInstance() {
        if (instance == null) {
            instance = new SingletonEx(); // create only once
        }
        return instance;
    }

    // Example method
    public void showMessage() {
        System.out.println("Hello from SingletonEx!");
    }

    public static void main(String[] args) {
        // Access SingletonEx
        SingletonEx s1 = SingletonEx.getInstance();
        SingletonEx s2 = SingletonEx.getInstance();

        s1.showMessage();

        // Verify both references point to the same object
        System.out.println("Are both instances the same? " + (s1 == s2));
    }
}

