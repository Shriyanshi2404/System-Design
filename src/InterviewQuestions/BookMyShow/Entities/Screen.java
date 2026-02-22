package InterviewQuestions.BookMyShow.Entities;

import java.time.LocalDate;
import java.util.*;

public class Screen {
    private final int screenId;
    private final List<Seat> seats;
    private final Map<LocalDate, List<Show>> showMap;

    public Screen(int id, List<Seat> seatList)
    {
        this.screenId = id;
        this.seats = seatList;
        showMap = new HashMap<>();
    }

    public int getScreenId()
    {
        return this.screenId;
    }

    public List<Seat> getSeats()
    {
        return this.seats;
    }

    public void addShow(Show show)
    {
        showMap.computeIfAbsent(show.getShowDate(),  d -> new ArrayList<>())
                        .add(show);
    }

    public List<Show> getShows(LocalDate date)
    {
        return showMap.getOrDefault(date, List.of());
    }
}
