package Designs.ParkingLot.Vehicle;

import Designs.ParkingLot.ParkingFees.ParkingFeeStrategy;

public class CarVehicle extends Vehicle {

    /**
     * This class represents a car, which is a type of vehicle.
     * It extends the Vehicle class and provides specific behavior for cars.
     *
     * @param licensePlate The unique identifier for the car.
     * @param parkingFeeStrategy The strategy used to calculate parking fees for the car.
     */
    public CarVehicle(String licensePlate, ParkingFeeStrategy parkingFeeStrategy) {
        super("Car", licensePlate, parkingFeeStrategy);
    }

}
