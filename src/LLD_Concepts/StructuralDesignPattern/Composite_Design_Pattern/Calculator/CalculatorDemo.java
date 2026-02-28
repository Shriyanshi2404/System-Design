package LLD_Concepts.StructuralDesignPattern.Composite_Design_Pattern.Calculator;

import LLD_Concepts.StructuralDesignPattern.Composite_Design_Pattern.Calculator.Component.ArithmeticExpression;
import LLD_Concepts.StructuralDesignPattern.Composite_Design_Pattern.Calculator.Composite.Expression;
import LLD_Concepts.StructuralDesignPattern.Composite_Design_Pattern.Calculator.Leaf.Number;

public class CalculatorDemo {
    public static void main(String[] args)
    {
        System.out.println("======= Composite Design Pattern ======");
        // 2*(1+7) tree structure for evaluation
       /*
                         *
                       /   \
                     2      +
                           / \
                          1   7
        */

        // Create leaf
        ArithmeticExpression number1 = new Number(2);
        ArithmeticExpression number2 = new Number(1);
        ArithmeticExpression number3 = new Number(7);

        // Create composite
        ArithmeticExpression addExpression = new Expression(number2, number3, OperationType.ADD);
        ArithmeticExpression parentExpression = new Expression(number1, addExpression, OperationType.MULTIPLY);

        parentExpression.evaluate();
    }
}
