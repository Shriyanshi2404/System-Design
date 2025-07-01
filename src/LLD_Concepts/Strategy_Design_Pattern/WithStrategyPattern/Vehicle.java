package LLD_Concepts.Strategy_Design_Pattern.WithStrategyPattern;

import LLD_Concepts.Strategy_Design_Pattern.WithStrategyPattern.Strategy.DrivingStrategy;

public class Vehicle {

    /** Vehicle class uses a DrivingStrategy to define its driving behavior.
     * This allows for different driving strategies to be used at runtime.
     * The driving strategy can be changed without modifying the Vehicle class.
     */
    DrivingStrategy driveObj;

    /** * Constructor to initialize the Vehicle with a specific driving strategy.
     * This is known as constructor injection.
     * @param driveObj The driving strategy to be used by the vehicle.
     */
    Vehicle(DrivingStrategy driveObj) {
        this.driveObj = driveObj;
    }

    public String drive() {
        return driveObj.drive();
    }
}
