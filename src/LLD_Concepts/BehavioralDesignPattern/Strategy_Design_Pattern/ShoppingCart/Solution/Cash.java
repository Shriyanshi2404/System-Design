package LLD_Concepts.BehavioralDesignPattern.Strategy_Design_Pattern.ShoppingCart.Solution;


// Concrete strategy - for cash payment
public class Cash implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paying the cart bill via CASH and total amount is : " + amount);
    }
}
