package InterviewQuestions.BookMyShow.Service;

import InterviewQuestions.BookMyShow.Entities.*;
import InterviewQuestions.BookMyShow.Enum.City;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BookingService {

    private final Map<UUID, Booking> bookings = new HashMap<>();

    public Booking getBooking(UUID bookingId)
    {
        return bookings.get(bookingId);
    }

    public Booking book(User user, Show show, List<Integer> seats)
    {
        if(!show.lockSeats(seats))
            throw new RuntimeException("Seat unavailable, Please select different seats");

        //simulated payment flow here, we can invoke Pay method of Payment Controller
        Payment payment = new Payment(PaymentStatus.SUCCESSFUL);

        if (payment.getStatus() == PaymentStatus.SUCCESSFUL) {
            show.confirmSeats(seats);
            Booking newBooking =  new Booking(user, payment, seats, show);
            bookings.put(newBooking.getBookingId(), newBooking);
            return newBooking;
        } else {
            show.releaseSeats(seats);
            throw new RuntimeException("Payment failed");
        }

    }

    public List<Booking> getBookingsForUser(User user)
    {
        return bookings.values()
                .stream()
                .filter(b -> b.getUser().equals(user))
                .toList();
    }
}
