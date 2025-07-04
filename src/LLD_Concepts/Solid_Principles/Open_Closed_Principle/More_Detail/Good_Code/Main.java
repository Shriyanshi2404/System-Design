package LLD_Concepts.Solid_Principles.Open_Closed_Principle.More_Detail.Good_Code;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        PaymentMethod creditCard = new CreditCard();
        PaymentMethod upi = new UPI();

        processor.processPayment(creditCard,100);
        processor.processPayment(upi,120);
    }
}
