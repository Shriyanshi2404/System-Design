package LLD_Concepts.CreationalDesignPattern.Abstract_Factory_Pattern.Factory;

import LLD_Concepts.CreationalDesignPattern.Abstract_Factory_Pattern.Product.Nano;
import LLD_Concepts.CreationalDesignPattern.Abstract_Factory_Pattern.Product.Swift;
import LLD_Concepts.CreationalDesignPattern.Abstract_Factory_Pattern.Product.Vehicle;

/**
 * CompactVehicleFactory is a concrete factory that implements the VehicleFactory interface.
 * It produces compact vehicles like Swift and Nano.
 */
public class CompactVehicleFactory implements VehicleFactory {

    @Override
    public Vehicle getCompactVehicle(String compactVehicleName) {
        if(compactVehicleName.equalsIgnoreCase("SWIFT"))
            return new Swift();
        else if(compactVehicleName.equalsIgnoreCase("NANO"))
            return new Nano();
        return null;
    }

    @Override
    public Vehicle getLuxuryVehicle(String luxuryVehicleName) {
        // Compact factory does not produce luxury vehicles
        return null;
    }
}