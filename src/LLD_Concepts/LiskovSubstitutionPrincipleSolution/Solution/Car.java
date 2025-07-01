package LLD_Concepts.LiskovSubstitutionPrincipleSolution.Solution;

public class Car extends EngineVehicle {

    // A car is a type of vehicle with 4 wheels, so we override getNumberOfWheels() method
    // but car has an engine so no need to override hasEngine() method
    @Override
    public Integer getNumberOfWheels() {
        return 4; // A car has 4 wheels
    }
}
