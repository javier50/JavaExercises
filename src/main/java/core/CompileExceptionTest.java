package core;

public class CompileExceptionTest {
    public static void main(String[] args) {
        Parent1 c = new Child1(); // Parent has all needed to be created by Child
        // Polymorphism: parent reference to child object
        //Child1 c = new Parent1();// Error - missing values to create child by parent
        c.print();
    }
}

class Parent1 {
    public void print() {
        System.out.println("This is Parent");
    }
}

class Child1 extends Parent1 {
    @Override
    public void print() {
        System.out.println("This is Child");
    }
}
