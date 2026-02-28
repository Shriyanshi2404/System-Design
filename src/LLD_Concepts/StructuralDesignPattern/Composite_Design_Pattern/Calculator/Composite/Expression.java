package LLD_Concepts.StructuralDesignPattern.Composite_Design_Pattern.Calculator.Composite;

import LLD_Concepts.StructuralDesignPattern.Composite_Design_Pattern.Calculator.Component.ArithmeticExpression;
import LLD_Concepts.StructuralDesignPattern.Composite_Design_Pattern.Calculator.OperationType;

// Step 3: Composite - Folder
public class Expression implements ArithmeticExpression {
    ArithmeticExpression leftExpression;
    ArithmeticExpression rightExpression;
    OperationType operationType;


    public Expression(ArithmeticExpression leftExpression, ArithmeticExpression rightExpression, OperationType operationType)
    {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operationType = operationType;
    }

    @Override
    public int evaluate()
    {
        int result = 0;
        switch (operationType) {
            case ADD:
            {
                result = leftExpression.evaluate() + rightExpression.evaluate();
                break;
            }
            case SUBTRACT:
            {
                result = leftExpression.evaluate() - rightExpression.evaluate();
                break;
            }
            case MULTIPLY:
            {
                result = leftExpression.evaluate() * rightExpression.evaluate();
                break;
            }
            case DIVIDE:
            {
                result = leftExpression.evaluate() / rightExpression.evaluate();
                break;
            }
            default:
            {
                System.out.println("Invalid operation type");
            }
        }
        System.out.println("Expression value is:" + result);
        return result;
    }
}
