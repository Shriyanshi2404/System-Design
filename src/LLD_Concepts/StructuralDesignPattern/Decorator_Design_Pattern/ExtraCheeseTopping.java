package LLD_Concepts.StructuralDesignPattern.Decorator_Design_Pattern;

public class ExtraCheeseTopping extends ToppingDecorator {

    private final BasePizza basePizza;

    /**
     * Constructor for ExtraCheeseTopping.
     *
     * @param basePizza The base pizza to which the extra cheese topping will be added
     */
    public ExtraCheeseTopping(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int costOfPizza() {
        return basePizza.costOfPizza() + 10; // Add the cost of the topping
    }

    @Override
    public String pizzaName() {
        String toppingName = "Extra Cheese";
        String pizzaName = basePizza.pizzaName();
        return pizzaName + " with " + toppingName; // Include the topping in the description
    }
}
