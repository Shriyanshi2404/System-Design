package LLD_Concepts.StructuralDesignPattern.Decorator_Design_Pattern;

public class Farmhouse extends BasePizza {

    @Override
    public int costOfPizza() {
        return 250;
    }

    @Override
    public String pizzaName() {
        return "Farmhouse Pizza";
    }
}
