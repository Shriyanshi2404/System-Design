package Designs.ParkingLot.ParkingFees;

public interface ParkingFeeStrategy {

    /**
     * Processes the payment based on the vehicle type, duration, and duration type.
     *
     * @param vehicleType The type of vehicle (e.g., Car, Bike, Truck).
     * @param duration The duration for which the vehicle is parked.
     * @param durationType The type of duration (e.g., Hourly, Daily).
     * @return The total amount to be paid.
     */
    double calculateFee(String vehicleType, int duration, DurationType durationType);
}
