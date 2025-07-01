package LLD_Concepts.LiskovSubstitutionPrincipleSolution.Solution;

public class EngineVehicle extends Vehicle {

    /** This class represents a vehicle that has an engine.
     * It extends the Vehicle class and overrides the methods to provide specific behavior for vehicles with engines.
     */
    public Boolean hasEngine() {
        return true;
    }
}
