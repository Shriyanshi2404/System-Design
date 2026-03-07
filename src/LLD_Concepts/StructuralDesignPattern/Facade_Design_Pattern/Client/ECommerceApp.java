package LLD_Concepts.StructuralDesignPattern.Facade_Design_Pattern.Client;

import LLD_Concepts.StructuralDesignPattern.Facade_Design_Pattern.Facade.OrderFacade;

public class ECommerceApp {

    public static void main(String[] args)
    {
        System.out.println("====== Facade Design Pattern Demo ======");

        // Client interacts with a simple Facade, not with all subsystems.
        OrderFacade orderFacade = new OrderFacade();

        // Place order with one call to Facade
        orderFacade.createOrder("MacBook Pro", "Credit Card");

        // Place another order with one call to Facade
        orderFacade.createOrder("Cricket Bat", "UPI");
    }
}
