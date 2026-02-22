package InterviewQuestions.BookMyShow.Entities;

import InterviewQuestions.BookMyShow.Enum.SeatStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Show {
    private final Movie movie;
    private final LocalDate showDate;
    private final LocalTime showTime;
    private final Map<Integer, SeatStatus> seatStatusMap;
    private final Map<Integer, ReentrantLock> seatLocks;

    public Show(Movie movie, Screen screen, LocalDate date, LocalTime time)
    {
        this.movie = movie;
        this.showDate = date;
        this.showTime = time;
        seatStatusMap = new HashMap<>();
        seatLocks = new HashMap<>();

        for(Seat seat : screen.getSeats())
        {
            // mark seat as available
            seatStatusMap.put(seat.getSeatId(), SeatStatus.AVAILABLE);
            // adding new object for seat lock
            seatLocks.put(seat.getSeatId(), new ReentrantLock());
        }
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public boolean lockSeats(List<Integer> seats)
    {
        List<Integer> sortedSeats = new ArrayList<>(seats);

        //sorting i am doing to avoid deadlock scenario
        Collections.sort(sortedSeats);
        List<ReentrantLock> acquiredLocks = new ArrayList<>();
        try {
            // Phase 1 : acquire all locks
            for(int seatId : sortedSeats)
            {
                ReentrantLock lock = seatLocks.get(seatId);
                lock.lock(); // lock the seat
                acquiredLocks.add(lock);
            }
            // Phase 2 : checking seat availability
            for (int seatId : sortedSeats) {
                if (seatStatusMap.get(seatId) != SeatStatus.AVAILABLE)
                    return false;
            }
            // Phase 3: mark seat as locked
            for(int seatId : sortedSeats)
            {
                seatStatusMap.put(seatId, SeatStatus.LOCKED);
            }
            return true;
        }
        finally {
            // Phase 4: release locks
            for (ReentrantLock lock : acquiredLocks) {
                lock.unlock();
            }
        }
    }

    public void confirmSeats(List<Integer> seatIds) {
        for (int seatId : seatIds) {
            seatStatusMap.put(seatId, SeatStatus.BOOKED);
        }
    }

    public void releaseSeats(List<Integer> seatIds) {
        for (int seatId : seatIds) {
            seatStatusMap.put(seatId, SeatStatus.AVAILABLE);
        }
    }
}
