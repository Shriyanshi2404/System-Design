package Designs.ParkingLot.Payment;

public class CashPayment implements PaymentStrategy {
    /**
     * This class implements the PaymentStrategy interface for cash payments.
     * It provides a method to process cash payments.
     */
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing cash payment of $" + amount);
        // Logic for cash payment processing
    }
}
