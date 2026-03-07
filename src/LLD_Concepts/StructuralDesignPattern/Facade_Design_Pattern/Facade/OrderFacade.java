package LLD_Concepts.StructuralDesignPattern.Facade_Design_Pattern.Facade;

import LLD_Concepts.StructuralDesignPattern.Facade_Design_Pattern.SubSystems.InventoryService;
import LLD_Concepts.StructuralDesignPattern.Facade_Design_Pattern.SubSystems.NotificationService;
import LLD_Concepts.StructuralDesignPattern.Facade_Design_Pattern.SubSystems.PaymentService;
import LLD_Concepts.StructuralDesignPattern.Facade_Design_Pattern.SubSystems.ShippingService;

public class OrderFacade {
    public InventoryService inventoryService;
    public PaymentService paymentService;
    public ShippingService shippingService;
    public NotificationService notificationService;

    public OrderFacade()
    {
        this.inventoryService = new InventoryService();
        this.paymentService = new PaymentService();
        this.shippingService = new ShippingService();
        this.notificationService = new NotificationService();
    }

    public void createOrder(String productId, String paymentMethod)
    {
        // The following steps are hidden from the client and need to be executed in a specific order
        System.out.println("Placing order for product: " + productId);

        // Step 1: Check stock
        if(!inventoryService.checkStock(productId)) {
            System.out.println("Product is out of stock");
            return;
        }

        // Step 2 : Complete the payment
        if(!paymentService.makePayment(paymentMethod))
        {
            System.out.println("Payment failed");
            return;
        }

        // Step 3 : Ship the product
        shippingService.shipProduct(productId);

        // Step 4: Send confirmation
        notificationService.sendConfirmation(productId);

        System.out.println("Order placed successfully!");
    }
}
