package LLD_Concepts.Solid_Principles.Interface_Segmented_Principle;

public class Chef implements ChefInterface {
    String dish;

    public Chef(String dish) {
        this.dish = dish;
    }

    @Override
    public void cookFood(String dish) {
        System.out.println("Cooking " + dish);
    }
}
