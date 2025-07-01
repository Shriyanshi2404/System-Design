package LLD_Concepts.Strategy_Pattern_Design.WithStrategyPattern;

import LLD_Concepts.Strategy_Pattern_Design.WithStrategyPattern.Strategy.SportsDriveStrategy;

public class SportVehicle extends Vehicle {
    /** SportVehicle is a subclass of Vehicle.
     * It inherits the drive method from Vehicle.
     * And it passes SportsDriveStrategy to Vehicle constructor.
     */
    SportVehicle() {
        super(new SportsDriveStrategy());
    }

    // No need to override the drive method, as it will use the strategy defined in the constructor.
}
