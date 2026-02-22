package InterviewQuestions.BookMyShow.Entities;

import InterviewQuestions.BookMyShow.Enum.SeatCategory;

public class Seat {
    private final int seatId;
    private final SeatCategory seatCategory;

    public Seat(int id, SeatCategory category)
    {
        this.seatId = id;
        this.seatCategory = category;
    }

    public int getSeatId()
    {
        return this.seatId;
    }
}
