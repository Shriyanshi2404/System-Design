package LLD_Concepts.LiskovSubstitutionPrincipleSolution.FailureScenario;

public class Bicycle extends Vehicle {

    // A bicycle is a type of vehicle with 2 wheels but it does not have an engine
    // So we override the hasEngine() method to return false, but this will break functionality if we try to use Bicycle as a Vehicle in a context that expects an engine.
    @Override
    public Boolean hasEngine() {
        return null; // A bicycle does not have an engine
    }

    // A bicycle has 2 wheels so no need to override getNumberOfWheels() method
}
