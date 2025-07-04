package LLD_Concepts.Solid_Principles.Open_Closed_Principle.More_Detail.Good_Code;

public class CreditCard implements PaymentMethod{

    @Override
    public void pay(double amount) {
        System.out.println("Making Payment via Credit Card" + amount);
    }
}
