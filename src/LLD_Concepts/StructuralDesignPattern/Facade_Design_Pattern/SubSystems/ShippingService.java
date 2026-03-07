package LLD_Concepts.StructuralDesignPattern.Facade_Design_Pattern.SubSystems;

// Subsystem C: Shipping
public class ShippingService {

    public void shipProduct(String productId)
    {
        System.out.println("Shipping the product having product Id: " + productId);
    }
}
