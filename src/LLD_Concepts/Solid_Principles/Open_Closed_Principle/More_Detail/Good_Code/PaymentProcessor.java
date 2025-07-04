package LLD_Concepts.Solid_Principles.Open_Closed_Principle.More_Detail.Good_Code;

public class PaymentProcessor {
    public void processPayment(PaymentMethod paymentMethod,double amount){
       paymentMethod.pay(amount);
    }
}
