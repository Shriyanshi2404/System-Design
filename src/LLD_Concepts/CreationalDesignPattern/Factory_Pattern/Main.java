package LLD_Concepts.CreationalDesignPattern.Factory_Pattern;
/**
 * Factory Pattern Example
 * This example demonstrates the Factory Design Pattern where we create a ShapeFactory to generate different types of shapes.
 * The Shape interface defines the methods that all shapes must implement.
 * Circle and Square classes implement the Shape interface.
 * The ShapeFactory class is responsible for creating instances of shapes based on the provided type.
 */
public class Main {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // Get Circle object and call its methods
        Shape circleShapeObj = shapeFactory.getShape("CIRCLE");
        circleShapeObj.draw();
        circleShapeObj.erase();
        circleShapeObj.resize();

        // Get Square object and call its methods
        Shape squareShapeObj = shapeFactory.getShape("SQUARE");
        squareShapeObj.draw();
        squareShapeObj.erase();
        squareShapeObj.resize();
    }
}
