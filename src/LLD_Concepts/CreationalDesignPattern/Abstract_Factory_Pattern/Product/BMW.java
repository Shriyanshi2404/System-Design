package LLD_Concepts.CreationalDesignPattern.Abstract_Factory_Pattern.Product;

public class BMW implements Vehicle {

    @Override
    public void vehicleType() {
        System.out.println("This is a BMW luxury vehicle.");
    }
}
