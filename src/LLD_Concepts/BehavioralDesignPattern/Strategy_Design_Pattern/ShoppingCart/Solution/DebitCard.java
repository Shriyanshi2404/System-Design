package LLD_Concepts.BehavioralDesignPattern.Strategy_Design_Pattern.ShoppingCart.Solution;

// Concrete strategy - for debit card payment
public class DebitCard implements PaymentStrategy {

    String emailId;

    DebitCard(String emailId) {
        this.emailId = emailId;
    }

    public void pay(int amount) {
        System.out.println("Paying the cart bill via DEBIT CARD and total amount is : " + amount +
                " and email id is : " + emailId);
    }
}
