package LLD_Concepts.Solid_Principles.Interface_Segmented_Principle;

public class Waiter implements WaiterInterface {
    String dish;
    int quantity;

    public Waiter(String dish, int quantity) {
        this.dish = dish;
        this.quantity = quantity;
    }

    @Override
    public void takeOrder(String dish, int quantity) {
        System.out.println("Taking order for " + quantity + " of " + dish);
    }

    @Override
    public void serveFood() {
        System.out.println("Serving " + this.dish);
    }
}
