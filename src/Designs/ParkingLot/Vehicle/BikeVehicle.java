package Designs.ParkingLot.Vehicle;

import Designs.ParkingLot.ParkingFees.ParkingFeeStrategy;

public class BikeVehicle extends Vehicle {

    /**
     * This class represents a bike, which is a type of vehicle.
     * It extends the Vehicle class and provides specific behavior for bikes.
     */
    public BikeVehicle(String licensePlate, ParkingFeeStrategy parkingFeeStrategy) {
        super("Bike", licensePlate, parkingFeeStrategy);
    }
}
