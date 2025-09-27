package Designs.ParkingLot.ParkingFees;

public class BasicHourlyRateStrategy implements ParkingFeeStrategy {

    @Override
    public double calculateFee(String vehicleType, int duration, DurationType durationType) {
        switch(vehicleType.toLowerCase()) {
            case "car":
                /**
                 * For cars, the hourly rate is $10.
                 * If the duration type is hourly, we charge $10 per hour.
                 * If the duration type is daily, we charge $10 per hour for 24 hours.
                 */
                return durationType == DurationType.HOUR ? 10 * duration : 10 * duration * 24;
            case  "bike":
                /**
                 * For bikes, the hourly rate is $5.
                 * If the duration type is hourly, we charge $5 per hour.
                 * If the duration type is daily, we charge $5 per hour for 24 hours.
                 */
                return durationType == DurationType.HOUR ? 5 * duration : 5 * duration * 24;
            case "truck":
                /**
                 * For trucks, the hourly rate is $20.
                 * If the duration type is hourly, we charge $20 per hour.
                 * If the duration type is daily, we charge $20 per hour for 24 hours.
                 */
                return durationType == DurationType.HOUR ? 20 * duration : 20 * duration * 24;
            default:
                /**
                 * For any other vehicle type, we assume a default rate of $15.
                 * If the duration type is hourly, we charge $15 per hour.
                 * If the duration type is daily, we charge $15 per hour for 24 hours.
                 */
                return durationType == DurationType.HOUR ? 15 * duration : 15 * duration *24;
        }
    }
}
