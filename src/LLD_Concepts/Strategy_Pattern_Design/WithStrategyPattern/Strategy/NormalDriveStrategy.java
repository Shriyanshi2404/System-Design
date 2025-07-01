package LLD_Concepts.Strategy_Pattern_Design.WithStrategyPattern.Strategy;

public class NormalDriveStrategy implements DrivingStrategy {
    /**
     * NormalDriveStrategy implements the DrivingStrategy interface.
     * It provides a specific implementation of the drive method.
     */
    @Override
    public String drive() {
        // some code
        return "Normal driving capability";
    }
}
