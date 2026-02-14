package LLD_Concepts.CreationalDesignPattern.Factory_Pattern.Product;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }

    @Override
    public void erase() {
        System.out.println("Inside Circle::erase() method.");
    }

    @Override
    public void resize() {
        System.out.println("Inside Circle::resize() method.");
    }
}
