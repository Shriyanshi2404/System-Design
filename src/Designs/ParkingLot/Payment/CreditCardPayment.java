package Designs.ParkingLot.Payment;

public class CreditCardPayment implements PaymentStrategy {

    /**
     * This class implements the PaymentStrategy interface for credit card payments.
     * It provides a method to process credit card payments.
     */
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment through credit card of $" + amount);
        // Logic for credit card payment processing
    }
}
