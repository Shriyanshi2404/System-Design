package LLD_Concepts.Solid_Principles.Interface_Segmented_Principle;

/**
 * Interface Segregation Principle (ISP) states that no client should be forced to depend on methods it does not use.
 * Means interfaces should be designed to be client-specific rather than general-purpose and client should not implement unnecessary functions which are of no use.
 * This principle encourages the creation of smaller, more specific interfaces rather than a large, general-purpose interface.
 * In this example, we demonstrate how to apply the ISP by creating separate interfaces for Chef and Waiter responsibilities.
 */
public class Interface_Segmented_Principle {

    public static void main(String[] args) {
        String dish = "Pasta";
        int quantity = 2;

        System.out.println("Chef responsibility: Cooking food");
        ChefInterface chef = new Chef(dish);
        chef.cookFood(dish);

        System.out.println("Waiter responsibility: Taking order and serving food");
        WaiterInterface waiter = new Waiter(dish, quantity);
        waiter.takeOrder(dish, quantity);
        waiter.serveFood();
    }
}
