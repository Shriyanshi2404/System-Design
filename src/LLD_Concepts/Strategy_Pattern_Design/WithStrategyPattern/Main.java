package LLD_Concepts.Strategy_Pattern_Design.WithStrategyPattern;

/**
 * Main class to demonstrate the Strategy Pattern in action.
 * It creates instances of different vehicle types and prints their driving capabilities.
 */
public class Main {

    public static void main(String[] args) {
        Vehicle passengerVehicle = new PassengerVehicle();
        System.out.println(passengerVehicle.drive());
        // Output: Normal driving capability

        Vehicle sportVehicle = new SportVehicle();
        System.out.println(sportVehicle.drive());
        // Output: Sport driving capability

        Vehicle offRoadVehicle = new OffRoadVehicle();
        System.out.println(offRoadVehicle.drive());
        // Output: Sport driving capability
    }
}
