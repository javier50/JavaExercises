package core;

public class ThrowVsThrows {
    public void checkAge(int age){
        if(age<18)
            throw new ArithmeticException("Not Eligible for voting");
        else
            System.out.println("Eligible for voting");
    }

    public int division(int a, int b) throws ArithmeticException{
        int t = a/b;
        return t;
    }
    
    public static void main(String args[]){
        ThrowVsThrows obj = new ThrowVsThrows();

        // Throw
        obj.checkAge(13);
        System.out.println("End Of Program");

        // Throws
        try{
            System.out.println(obj.division(15,0));
        }
        catch(ArithmeticException e){
            System.out.println("You shouldn't divide number by zero");
        }
    }
}
