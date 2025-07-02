package LLD_Concepts.StructuralDesignPattern.Decorator_Design_Pattern;
/**
 * BasePizza is an abstract class that defines the structure for pizza objects.
 * It declares two abstract methods: costOfPizza() and pizzaName().
 * Concrete pizza classes will extend this class and provide implementations for these methods.
 */
public abstract class BasePizza {

    public abstract int costOfPizza();
    public abstract String pizzaName();
}
