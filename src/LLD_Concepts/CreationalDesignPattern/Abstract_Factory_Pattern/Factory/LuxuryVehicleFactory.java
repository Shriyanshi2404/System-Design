package LLD_Concepts.CreationalDesignPattern.Abstract_Factory_Pattern.Factory;

import LLD_Concepts.CreationalDesignPattern.Abstract_Factory_Pattern.Product.BMW;
import LLD_Concepts.CreationalDesignPattern.Abstract_Factory_Pattern.Product.Mercedes;
import LLD_Concepts.CreationalDesignPattern.Abstract_Factory_Pattern.Product.Vehicle;

/*
 * LuxuryVehicleFactory.java
 * This class implements the VehicleFactory interface to create luxury vehicles.
 */
public class LuxuryVehicleFactory implements VehicleFactory {
    @Override
    public Vehicle getLuxuryVehicle(String luxuryVehicleName) {
        if (luxuryVehicleName.equalsIgnoreCase("BMW")) {
            return new BMW();
        } else if (luxuryVehicleName.equalsIgnoreCase("Mercedes")) {
            return new Mercedes();
        }
        return null;
    }

    @Override
    public Vehicle getCompactVehicle(String compactVehicleName) {
        // Luxury factory does not produce compact vehicles
        return null;
    }
}
