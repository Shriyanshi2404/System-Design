package LLD_Concepts.CreationalDesignPattern.Factory_Pattern.Product;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }

    @Override
    public void erase() {
        System.out.println("Inside Square::erase() method.");
    }

    @Override
    public void resize() {
        System.out.println("Inside Square::resize() method.");
    }
}
