package LLD_Concepts.LiskovSubstitutionPrincipleSolution.FailureScenario;

public class Car extends Vehicle {

    // A car is a type of vehicle with 4 wheels, so we override getNumberOfWheels() method
    // but car has an engine so no need to override hasEngine() method
    @Override
    public Integer getNumberOfWheels() {
        return 4; // A car has 4 wheels
    }
}
