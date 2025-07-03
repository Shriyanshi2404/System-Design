package LLD_Concepts.CreationalDesignPattern.Factory_Pattern;
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
