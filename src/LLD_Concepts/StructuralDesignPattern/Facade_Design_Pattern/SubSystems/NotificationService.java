package LLD_Concepts.StructuralDesignPattern.Facade_Design_Pattern.SubSystems;

// Subsystem D: Notification
public class NotificationService {
    public void sendConfirmation(String productId) {
        System.out.println("Sending order confirmation for product: " + productId);
    }
}
