package LLD_Concepts.Strategy_Pattern_Design.WithStrategyPattern;

import LLD_Concepts.Strategy_Pattern_Design.WithStrategyPattern.Strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle {
    /** OffRoadVehicle is a subclass of Vehicle.
     * It inherits the drive method from Vehicle.
     * And it passes SportsDriveStrategy to Vehicle constructor.
     */
    OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }
}
