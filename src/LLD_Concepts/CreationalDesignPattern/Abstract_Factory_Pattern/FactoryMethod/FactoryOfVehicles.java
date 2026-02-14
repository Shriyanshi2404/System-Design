package LLD_Concepts.CreationalDesignPattern.Abstract_Factory_Pattern.FactoryMethod;

import LLD_Concepts.CreationalDesignPattern.Abstract_Factory_Pattern.Factory.CompactVehicleFactory;
import LLD_Concepts.CreationalDesignPattern.Abstract_Factory_Pattern.Factory.LuxuryVehicleFactory;
import LLD_Concepts.CreationalDesignPattern.Abstract_Factory_Pattern.Factory.VehicleFactory;

public class FactoryOfVehicles {

    public VehicleFactory getVehicleFactory(String vehicleType) {
        if (vehicleType.equalsIgnoreCase("Luxury")) {
            return new LuxuryVehicleFactory();
        } else if (vehicleType.equalsIgnoreCase("Compact")) {
            return new CompactVehicleFactory();
        }
        return null;
    }
}
