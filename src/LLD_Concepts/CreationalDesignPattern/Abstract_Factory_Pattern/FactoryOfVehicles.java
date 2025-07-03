package LLD_Concepts.CreationalDesignPattern.Abstract_Factory_Pattern;

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
