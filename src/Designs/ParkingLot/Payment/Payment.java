package Designs.ParkingLot.Payment;

public class Payment {
    private double amount;
    private PaymentStrategy paymentStrategy;

    public Payment(double amount, PaymentStrategy paymentStrategy) {
        this.amount = amount;
        this.paymentStrategy = paymentStrategy;
    }

    /**
     * Processes the payment using the specified payment strategy.
     */
    public void processPayment() {
        if (amount > 0) {
            paymentStrategy.processPayment(amount);  // Delegating to strategy
        } else {
            System.out.println("Invalid payment amount.");
        }
    }
}
