package LLD_Concepts.LiskovSubstitutionPrincipleSolution.FailureScenario;

import java.util.ArrayList;
import java.util.List;
/**
 * Liskov Substitution Principle (LSP) states that objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.
 * In this example, we have a Vehicle class and its subclasses MotorCycle and Car.
 * Both subclasses can be used interchangeably with the Vehicle type without breaking the functionality.
 * We also have a Bicycle class which does not follow the LSP as it does not have an engine.
 * The main method demonstrates how to use these classes while adhering to the LSP.
 */
public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new MotorCycle());
        vehicleList.add(new Car());
        /**
         * Bicycle is not a type of vehicle with an engine, so it should not be used as a substitute for Vehicle.
         * It will break the functionality if we try to use Bicycle as a Vehicle in a context that expects an engine.
         * The Below line will throw NullPointerException when we call hasEngine() method on a Bicycle object.
         */
        vehicleList.add(new Bicycle());

        for (Vehicle vehicle : vehicleList) {
            System.out.println("Vehicle has " + vehicle.getNumberOfWheels() + " wheels and has engine: " + vehicle.hasEngine().toString());
        }
    }
}
