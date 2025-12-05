package core;

public class CheckUncheckExceptionEx {
    public static void main(String[] args) throws Exception {
        try {
            System.out.printf("isValidChecked: %b%n", CheckUncheckExceptionEx.isValidChecked(1));
            System.out.printf("isValidUnchecked: %b%n", CheckUncheckExceptionEx.isValidUnchecked(1));
        } catch (InvalidPaymentCheckedException e) {
            System.out.println("ChekedException: " + e.getMessage());
        } catch (InvalidPaymentUncheckedException ue) {
            System.out.println("UnchekedException: " + ue.getMessage());
        }
    }

    public static boolean isValidChecked(double amount) throws InvalidPaymentCheckedException {
        if (amount <= 0) {
            throw new InvalidPaymentCheckedException("Amount must be greater than zero");
        }
        return true;
    }

    public static boolean isValidUnchecked(double amount) throws InvalidPaymentUncheckedException {
        if (amount <= 0) {
            throw new InvalidPaymentUncheckedException("Amount must be greater than zero");
        }
        return true;
    }
}

// Custom Checked Exception
class InvalidPaymentCheckedException extends Exception {
    // Default constructor
    public InvalidPaymentCheckedException() {
        super("Invalid payment operation occurred");
    }

    // Constructor with custom message
    public InvalidPaymentCheckedException(String message) {
        super(message);
    }

    // Constructor with cause
    public InvalidPaymentCheckedException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Custom Unchecked exception
class InvalidPaymentUncheckedException extends RuntimeException {
    // Default constructor
    public InvalidPaymentUncheckedException() {
        super("Invalid payment operation occurred");
    }

    // Constructor with custom message
    public InvalidPaymentUncheckedException(String message) {
        super(message);
    }

    // Constructor with cause
    public InvalidPaymentUncheckedException(String message, Throwable cause) {
        super(message, cause);
    }
}