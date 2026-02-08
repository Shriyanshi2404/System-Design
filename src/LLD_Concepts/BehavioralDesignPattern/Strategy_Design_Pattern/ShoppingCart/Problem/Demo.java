package LLD_Concepts.BehavioralDesignPattern.Strategy_Design_Pattern.ShoppingCart.Problem;

public class Demo {

    public static void main(String[] args)
    {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processPayment("credit_card", 100);
        paymentProcessor.processPayment("debit_card", 120);
        paymentProcessor.processPayment("cash", 50);
        paymentProcessor.processPayment("net_banking", 300);
    }
}
