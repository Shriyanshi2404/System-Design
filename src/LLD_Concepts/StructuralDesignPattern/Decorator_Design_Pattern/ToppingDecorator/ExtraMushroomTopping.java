package LLD_Concepts.StructuralDesignPattern.Decorator_Design_Pattern.ToppingDecorator;

import LLD_Concepts.StructuralDesignPattern.Decorator_Design_Pattern.Base.BasePizza;

public class ExtraMushroomTopping extends ToppingDecorator {

    private final BasePizza basePizza;

    /**
     * Constructor for ExtraMushroomTopping.
     *
     * @param basePizza The base pizza to which the extra cheese topping will be added
     */
    public ExtraMushroomTopping(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int costOfPizza() {
        return basePizza.costOfPizza() + 50; // Adding cost of extra mushroom topping
    }

    @Override
    public String pizzaName() {
        String toppingName = "Extra Mushroom";
        String pizzaName = basePizza.pizzaName();
        return pizzaName + " with " + toppingName; // Include the topping in the description
    }
}
