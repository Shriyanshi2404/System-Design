package Designs.ParkingLot.Payment;

import Designs.ParkingLot.ParkingFees.DurationType;

public interface PaymentStrategy {

    void processPayment(double amount);
}
