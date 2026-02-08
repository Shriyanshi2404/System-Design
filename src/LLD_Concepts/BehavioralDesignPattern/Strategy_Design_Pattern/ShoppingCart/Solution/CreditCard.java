package LLD_Concepts.BehavioralDesignPattern.Strategy_Design_Pattern.ShoppingCart.Solution;

// Concrete strategy - for credit card payment
public class CreditCard implements PaymentStrategy {
    String creditCardNumber;

    CreditCard(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying the cart bill via CREDIT CARD and total amount is : " + amount +
                " and Last four digits of Credit card is : " + creditCardNumber.substring(creditCardNumber.length()-4));
    }
}
