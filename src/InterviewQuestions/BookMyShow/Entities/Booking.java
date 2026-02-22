package InterviewQuestions.BookMyShow.Entities;

import java.util.List;
import java.util.UUID;

public class Booking {
    private final UUID bookingId;
    private final User user;
    private final Payment payment;
    private final Show show;
    private final List<Integer> seats;

    public Booking(User user, Payment payment, List<Integer> seats, Show show)
    {
        this.user = user;
        this.payment = payment;
        this.bookingId = UUID.randomUUID();
        this.seats = seats;
        this.show = show;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public Payment getPayment() {
        return payment;
    }


}
