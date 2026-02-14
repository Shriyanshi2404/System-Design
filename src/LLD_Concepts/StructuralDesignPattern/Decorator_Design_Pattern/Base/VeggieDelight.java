package LLD_Concepts.StructuralDesignPattern.Decorator_Design_Pattern.Base;

public class VeggieDelight extends BasePizza {

    @Override
    public int costOfPizza() {
        return 300; // Cost of Veggie Delight pizza
    }

    @Override
    public String pizzaName() {
        return "Veggie Delight Pizza";
    }
}
