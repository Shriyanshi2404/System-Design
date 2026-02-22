package InterviewQuestions.BookMyShow.Controller;

import InterviewQuestions.BookMyShow.Entities.Movie;
import InterviewQuestions.BookMyShow.Entities.Show;
import InterviewQuestions.BookMyShow.Entities.Theatre;
import InterviewQuestions.BookMyShow.Enum.City;
import InterviewQuestions.BookMyShow.Service.TheatreService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class TheatreController {

    private final TheatreService theatreService;

    public TheatreController()
    {
        this.theatreService = new TheatreService();
    }

    public void addTheatre(Theatre theatre)
    {
        theatreService.addTheatre(theatre);
    }

    public Set<Movie> getMovies(City city, LocalDate date)
    {
        return theatreService.getMovies(city, date);
    }

    public List<Theatre> getTheatres(City city, Movie movie, LocalDate date) {
        return theatreService.getTheatres(city, movie, date);
    }

    public List<Show> getShows(Theatre theatre, LocalDate date, Movie movie)
    {
        return theatreService.getShows(theatre, date, movie);
    }
}
