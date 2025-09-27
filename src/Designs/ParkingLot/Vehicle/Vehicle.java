package Designs.ParkingLot.Vehicle;

import Designs.ParkingLot.ParkingFees.DurationType;
import Designs.ParkingLot.ParkingFees.ParkingFeeStrategy;

public abstract class Vehicle {
    private String vehicleType; // e.g., Car, Bike, Truck
    private String licensePlate; // Unique identifier for the vehicle
    private ParkingFeeStrategy parkingFeeStrategy; // Strategy for calculating parking fees

    public Vehicle(String vehicleType, String licensePlate, ParkingFeeStrategy parkingFeeStrategy) {
        this.vehicleType = vehicleType;
        this.licensePlate = licensePlate;
        this.parkingFeeStrategy = parkingFeeStrategy;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getVehicleType()  {
        return vehicleType;
    }

    public double calculateParkingFee(int duration, DurationType durationType) {
        return parkingFeeStrategy.calculateFee(vehicleType, duration, durationType);
    }

}
