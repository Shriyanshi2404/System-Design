package LLD_Concepts.StructuralDesignPattern.Facade_Design_Pattern.SubSystems;

// Subsystem B: Payment
public class PaymentService {

    public boolean makePayment(String paymentMethod)
    {
        System.out.println("Processing payment using: " + paymentMethod);
        return true; // assume payment always succeeds
    }
}
