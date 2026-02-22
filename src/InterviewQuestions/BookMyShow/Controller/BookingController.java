package InterviewQuestions.BookMyShow.Controller;

import InterviewQuestions.BookMyShow.Entities.Booking;
import InterviewQuestions.BookMyShow.Entities.Show;
import InterviewQuestions.BookMyShow.Entities.User;
import InterviewQuestions.BookMyShow.Service.BookingService;

import java.awt.print.Book;
import java.util.List;
import java.util.UUID;

public class BookingController {
    private final BookingService bookingService;

    public BookingController()
    {
        this.bookingService = new BookingService();
    }

    public Booking getBooking(UUID bookingId)
    {
        return bookingService.getBooking(bookingId);
    }

    public Booking createBooking(User user, Show show, List<Integer> seats)
    {
        Booking booking = bookingService.book(user, show, seats);
        return booking;
    }

    public List<Booking> getBookingsForUser(User user) {
        return bookingService.getBookingsForUser(user);
    }
}
