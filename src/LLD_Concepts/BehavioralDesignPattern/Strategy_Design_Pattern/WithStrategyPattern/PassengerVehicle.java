package LLD_Concepts.BehavioralDesignPattern.Strategy_Design_Pattern.WithStrategyPattern;

import LLD_Concepts.BehavioralDesignPattern.Strategy_Design_Pattern.WithStrategyPattern.Strategy.NormalDriveStrategy;

public class PassengerVehicle extends Vehicle {
    /** PassengerVehicle is a subclass of Vehicle.
     * It inherits the drive method from Vehicle.
     * And it passes NormalDriveStrategy to Vehicle constructor.
     */
    PassengerVehicle() {
        super(new NormalDriveStrategy());
    }
}
