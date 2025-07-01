package LLD_Concepts.Strategy_Pattern_Design.WithStrategyPattern.Strategy;

public class SportsDriveStrategy implements DrivingStrategy {
    /**
     * SportsDriveStrategy implements the DrivingStrategy interface.
     * It provides a specific implementation of the drive method.
     */
    @Override
    public String drive() {
        // some code
        return "Sport driving capability";
    }
}
