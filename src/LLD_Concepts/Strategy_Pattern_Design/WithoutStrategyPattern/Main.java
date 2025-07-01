package LLD_Concepts.Strategy_Pattern_Design.WithoutStrategyPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * In this example, we have a Vehicle class that has a drive() method.
 * The drive method returns a string indicating the driving capability of the vehicle.
 * We have three subclasses: PassengerVehicle, OffRoadVehicle, and SportVehicle.
 * Each subclass overrides the drive method to provide its own driving capability.
 * However, this leads to code duplication and violates the DRY principle since OffRoadVehicle and SportVehicle have the same driving capability.
 */
public class Main {

    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new PassengerVehicle());
        vehicleList.add(new OffRoadVehicle());
        vehicleList.add(new SportVehicle());

        for(Vehicle vehicle : vehicleList) {
           System.out.println("Vehicle has " + vehicle.drive());
        }

        /** Output
         * Vehicle has Normal driving capability
         * Vehicle has Sport driving capability
         * Vehicle has Sport driving capability
         *
         * Here, we can see that the PassengerVehicle uses the default driving capability,
         * while both OffRoadVehicle and SportVehicle use the sport driving capability, which prints redundant code
         */
    }
}
