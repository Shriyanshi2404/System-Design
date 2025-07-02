package LLD_Concepts.BehavioralDesignPattern.Strategy_Design_Pattern.WithStrategyPattern;

import LLD_Concepts.BehavioralDesignPattern.Strategy_Design_Pattern.WithStrategyPattern.Strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle {
    /** OffRoadVehicle is a subclass of Vehicle.
     * It inherits the drive method from Vehicle.
     * And it passes SportsDriveStrategy to Vehicle constructor.
     */
    OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }
}
