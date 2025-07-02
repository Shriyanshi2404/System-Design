package LLD_Concepts.BehavioralDesignPattern.Strategy_Design_Pattern.WithoutStrategyPattern;

public class OffRoadVehicle extends Vehicle {
    /** OffRoadVehicle is a subclass of Vehicle.
     * It inherits the drive method from Vehicle.
     * And it uses sport driving capability only.
     */

    @Override
    public String drive() {
        // some code
        return "Sport driving capability";
    }
}
