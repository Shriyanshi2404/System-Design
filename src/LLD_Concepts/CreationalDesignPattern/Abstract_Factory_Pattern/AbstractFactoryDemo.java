package LLD_Concepts.CreationalDesignPattern.Abstract_Factory_Pattern;

import LLD_Concepts.CreationalDesignPattern.Abstract_Factory_Pattern.Factory.VehicleFactory;
import LLD_Concepts.CreationalDesignPattern.Abstract_Factory_Pattern.FactoryMethod.FactoryOfVehicles;

/**
 * Main class to demonstrate the Abstract Factory Pattern for creating vehicles.
 * This example shows how to create different types of vehicles using factories.
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {

        FactoryOfVehicles factoryOfVehicles = new FactoryOfVehicles();

        VehicleFactory luxuryVehicleFactory = factoryOfVehicles.getVehicleFactory("Luxury");
        luxuryVehicleFactory.getLuxuryVehicle("BMW").vehicleType();

        VehicleFactory compactVehicleFactory = factoryOfVehicles.getVehicleFactory("Compact");
        compactVehicleFactory.getCompactVehicle("NANO").vehicleType();
    }
}
