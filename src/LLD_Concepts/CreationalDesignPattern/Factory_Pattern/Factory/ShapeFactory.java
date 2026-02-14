package LLD_Concepts.CreationalDesignPattern.Factory_Pattern.Factory;

import LLD_Concepts.CreationalDesignPattern.Factory_Pattern.Product.Circle;
import LLD_Concepts.CreationalDesignPattern.Factory_Pattern.Product.Shape;
import LLD_Concepts.CreationalDesignPattern.Factory_Pattern.Product.Square;

/**
 * ShapeFactory class that implements the Factory Design Pattern.
 * It is responsible for creating instances of shapes based on the provided type.
 * This allows for easy addition of new shapes without modifying existing code.
 */
public class ShapeFactory {

    public Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
