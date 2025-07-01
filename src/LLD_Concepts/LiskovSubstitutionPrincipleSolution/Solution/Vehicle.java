package LLD_Concepts.LiskovSubstitutionPrincipleSolution.Solution;

public class Vehicle {

    /* * This method returns the number of wheels of the vehicle.
     * It is a general method that can be overridden by all the subclasses of vehicle as every vehicle has a different number of wheels.
     * The default implementation returns null, indicating that the number of wheels is not defined.
     */
    public Integer getNumberOfWheels() {
        return 2;
    }
}