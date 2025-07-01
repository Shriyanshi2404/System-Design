package LLD_Concepts.LiskovSubstitutionPrincipleSolution.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * This class demonstrates the Liskov Substitution Principle by using a hierarchy of vehicle classes.
 * The Vehicle class is the base class, and it is extended by EngineVehicle, which represents vehicles with engines.
 * The Bicycle class is also a type of Vehicle but does not have an engine, so it extends Vehicle class without overriding the hasEngine() method.
 * But Car and MotorCycle class has Engine, so it extends EngineVehicle class, which in turn extends Vehicle class. So, both methods can be overridden in these classes.
 * The main method shows how to use these classes while adhering to the principle.
 */
public class MainClass {
    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new MotorCycle());
        vehicleList.add(new Car());
        vehicleList.add(new Bicycle());

        /**
         * Bicycle is a type of vehicle, but it does not have an engine.
         * However, it still adheres to the Liskov Substitution Principle as it can be used interchangeably with Vehicle.
         * The getNumberOfWheels() method is overridden to provide specific behavior for bicycles.
         * So if uncomment below code, it will give a compilation error "Cannot resolve method 'hasEngine' in 'Vehicle'".
         */
//        for (Vehicle vehicle : vehicleList) {
//            System.out.println("Vehicle has " + vehicle.getNumberOfWheels() + " wheels and has engine: " + vehicle.hasEngine().toString());
//        }
//
        List<EngineVehicle> engineVehicleList = new ArrayList<>();
        engineVehicleList.add(new MotorCycle());
        engineVehicleList.add(new Car());
        /**
         * Bicycle is not a type of vehicle with an engine, so it should not be used as a substitute for EngineVehicle.
         * It will break the functionality if we try to use Bicycle as an EngineVehicle in a context that expects an engine.
         * So if uncomment below code, it will throw compilation error 'adding 'EngineVehicle' in 'java.util.List' cannot be applied to 'Bicycle'.
         */
//        engineVehicleList.add(new Bicycle());



        /************** CORRECTED CODE *********************
         * The following code demonstrates how to use the classes while adhering to the Liskov Substitution Principle.
         * We can iterate over both EngineVehicle and Vehicle lists and call their respective methods without any issues.
         */
        List<EngineVehicle> engineVehicles = new ArrayList<>();
        engineVehicles.add(new MotorCycle());
        engineVehicles.add(new Car());

        for(EngineVehicle engineVehicle : engineVehicles) {
            System.out.println("Vehicle has " + engineVehicle.getNumberOfWheels() + " wheels and has engine: " + engineVehicle.hasEngine().toString());
        }

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new MotorCycle());
        vehicles.add(new Car());
        vehicles.add(new Bicycle());

        for(Vehicle vehicle : vehicles) {
            System.out.println("Vehicle has " + vehicle.getNumberOfWheels());
        }
    }
}
