package Designs.ParkingLot.Vehicle;

import Designs.ParkingLot.ParkingFees.ParkingFeeStrategy;

public class VehicleFactory {

    public Vehicle createVehicle(String vehicleType, String licensePlate, ParkingFeeStrategy parkingFeeStrategy) {
        switch (vehicleType) {
            case "Car":
                return new CarVehicle(licensePlate, parkingFeeStrategy);
            case "Bike":
                return new BikeVehicle(licensePlate, parkingFeeStrategy);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
        }
    }
}
