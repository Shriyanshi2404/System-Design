package LLD_Concepts.CreationalDesignPattern.Factory_Pattern.Product;
/**
 * Shape interface that defines the methods for different shapes.
 * All shapes must implement these methods to provide their specific behavior.
 */
public interface Shape {

    public void draw();
    public void erase();
    public void resize();
}
