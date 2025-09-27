package Designs.ParkingLot.ParkingFees;

public class PremiumRateStrategy implements ParkingFeeStrategy {

    @Override
    public double calculateFee(String vehicleType, int duration, DurationType durationType) {
        switch(vehicleType.toLowerCase()) {
            case "car":
                return durationType == DurationType.HOUR ? 15 * duration : 15 * duration * 24;
            case "bike":
                return durationType == DurationType.HOUR ? 10 * duration : 10 * duration * 24;
            case "truck":
                return durationType == DurationType.HOUR ? 30 * duration : 30 * duration * 24;
            default:
                return durationType == DurationType.HOUR ? 20 * duration : 20 * duration * 24;
        }
    }
}
