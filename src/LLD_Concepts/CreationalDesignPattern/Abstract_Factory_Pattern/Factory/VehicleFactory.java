package LLD_Concepts.CreationalDesignPattern.Abstract_Factory_Pattern.Factory;

import LLD_Concepts.CreationalDesignPattern.Abstract_Factory_Pattern.Product.Vehicle;

/**
 * VehicleFactory interface defines the methods to create different types of vehicles.
 * It serves as an abstract factory for creating luxury and compact vehicles.
 */
public interface VehicleFactory {
    Vehicle getLuxuryVehicle(String luxuryVehicleName);
    Vehicle getCompactVehicle(String compactVehicleName);
}
