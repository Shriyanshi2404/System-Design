package LLD_Concepts.BehavioralDesignPattern.Strategy_Design_Pattern.ShoppingCart.Problem;

// A simple payment processor class - bloated with payment logic
public class PaymentProcessor {

    void processPayment(String paymentMode, int amount) {
        switch (paymentMode) {
            case "credit_card" ->
                System.out.println("Paid amount of Rs."+ amount + " via Credit card");
            case "debit_card" ->
                System.out.println("Paid amount of Rs."+ amount + " via Debit card");
            case "cash" ->
                System.out.println("Paid amount of Rs."+ amount + " via Cash");
            default ->
                throw new IllegalStateException("Unexpected value of payment mode: " + paymentMode);
        }
    }
}
