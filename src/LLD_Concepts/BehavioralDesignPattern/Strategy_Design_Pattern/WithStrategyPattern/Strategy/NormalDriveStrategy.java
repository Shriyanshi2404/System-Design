package LLD_Concepts.BehavioralDesignPattern.Strategy_Design_Pattern.WithStrategyPattern.Strategy;

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
