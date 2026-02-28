package LLD_Concepts.StructuralDesignPattern.Composite_Design_Pattern.Calculator.Leaf;

import LLD_Concepts.StructuralDesignPattern.Composite_Design_Pattern.Calculator.Component.ArithmeticExpression;

// Step 2: Leaf - Number
public class Number implements ArithmeticExpression {
    int value;

    public Number(int value)
    {
        this.value = value;
    }

    @Override
    public int evaluate()
    {
        System.out.println("Number value is: " + value);
        return value;
    }
}
