package core;

class Parent {
    protected String name= "<Name>";
    public void print() {
        System.out.println("This is core.Parent");
    }
}

class Child extends Parent {
    private String lastName = "<lastName>";
    public void print() {
        System.out.println("This is core.Child");
    }
}

public class ExceptionsTest {
    public static void main(String[] args) {
        try {
            String x = null;
            x.toString(); // <-- it will trow a NullPointerException and also it's redundant;
        } catch(Exception e) {
            System.out.println("Catch Exception");
            e.printStackTrace();
        //} catch(NullPointerException e) { // <-- Unreachable exception,
            // if you want add a general exception you need to put at the final
            // Because all exception extend from 'Exception' class
            e.printStackTrace();
        }

        try {
            //core.Child c = new core.Parent();// <-- You can't do this,
            // you need to create the class from the core.Child class no from the core.Parent class

            Parent c = new Child();
            c.print(); // <-- this will print 'This is core.Child'

            //System.out.println(c.lastName);// Cannot resolve symbol 'lastName'
            // c is 'core.Parent' Object and this doesn't have the lastName variable
        } catch(Exception e) {
            System.out.println("Catch Exception");
        }

        try {
            Child c = new Child();
            c.print(); // <-- this will print 'This is core.Child'
            //System.out.println(c.lastName);// Cannot resolve symbol 'lastName'
            // The lastName variable needs to be 'public' or 'protected'
        } catch(Exception e) {
            System.out.println("Catch Exception");
        }
    }
}
