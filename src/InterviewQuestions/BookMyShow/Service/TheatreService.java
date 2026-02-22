package InterviewQuestions.BookMyShow.Service;

import InterviewQuestions.BookMyShow.Entities.Movie;
import InterviewQuestions.BookMyShow.Entities.Screen;
import InterviewQuestions.BookMyShow.Entities.Show;
import InterviewQuestions.BookMyShow.Entities.Theatre;
import InterviewQuestions.BookMyShow.Enum.City;

import java.time.LocalDate;
import java.util.*;

public class TheatreService {

    private final Map<City, List<Theatre>> cityTheatres = new HashMap<>();

    public void addTheatre(Theatre theatre)
    {
        cityTheatres.computeIfAbsent(theatre.getCity(), c -> new ArrayList<>())
                .add(theatre);
    }

    public Set<Movie> getMovies(City city, LocalDate date)
    {
        Set<Movie> movies = new HashSet<>();
        List<Theatre> theatresList = cityTheatres.getOrDefault(city, List.of());
        for(Theatre theatre : theatresList)
        {
            for(Screen screen : theatre.getScreens())
            {
                for(Show show : screen.getShows(date))
                {
                    movies.add(show.getMovie());
                }
            }
        }
        return movies;
    }

    public List<Theatre> getTheatres(City city, Movie movie, LocalDate date)
    {
        List<Theatre> theatresList = cityTheatres.getOrDefault(city, List.of());
        return theatresList.stream()
                .filter(t -> t.getScreens().stream()
                        .anyMatch(s -> s.getShows(date).stream()
                                .anyMatch(show -> show.getMovie().equals(movie))))
                .toList();
    }

    public List<Show> getShows(Theatre theatre, LocalDate date, Movie movie)
    {
        List<Show> shows = new ArrayList<>();
        for(Screen screen : theatre.getScreens())
        {
            for(Show show : screen.getShows(date))
            {
                if(show.getMovie().equals(movie))
                    shows.add(show);
            }
        }
        return shows;
    }
}
