package LLD_Concepts.BehavioralDesignPattern.Strategy_Design_Pattern.ShoppingCart.Solution;

public class Demo {

    public static void main(String[] args)
    {
        ShoppingCart shoppingCart = new ShoppingCart();
        // Paying via CREDIT CARD
        shoppingCart.setPaymentStrategy(new CreditCard("1234-5678-9012-3456"));
        shoppingCart.payBill(100);

        // Paying via DEBIT CARD
        shoppingCart.setPaymentStrategy(new DebitCard("johndoe@example.com"));
        shoppingCart.payBill(120);

        // Paying via CASH
        shoppingCart.setPaymentStrategy(new Cash());
        shoppingCart.payBill(50);

        // Paying via UPI
        shoppingCart.setPaymentStrategy(new UPI("johnjohnson@ybl"));
        shoppingCart.payBill(150);
    }
}
