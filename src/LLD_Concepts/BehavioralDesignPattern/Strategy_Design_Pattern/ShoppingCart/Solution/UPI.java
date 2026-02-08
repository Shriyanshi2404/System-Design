package LLD_Concepts.BehavioralDesignPattern.Strategy_Design_Pattern.ShoppingCart.Solution;


// Concrete strategy - for UPI payment
public class UPI implements PaymentStrategy{
    String upiId;

    UPI(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying the cart bill via UPI and total amount is : " + amount + " and UPI ID is : " + upiId);
    }
}
