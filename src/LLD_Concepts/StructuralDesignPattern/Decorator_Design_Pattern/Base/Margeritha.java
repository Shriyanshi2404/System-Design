package LLD_Concepts.StructuralDesignPattern.Decorator_Design_Pattern.Base;

public class Margeritha extends BasePizza {

    @Override
    public int costOfPizza() {
        return 100; // Cost of Margeritha pizza
    }

    @Override
    public String pizzaName() {
        return "Margeritha Pizza";
    }
}
