package InterviewQuestions.BookMyShow.Entities;

import InterviewQuestions.BookMyShow.Enum.City;

import java.util.List;

public class Theatre {
    private final String name;
    private final City city;
    private final List<Screen> screens;

    public Theatre(String theatreName, City city, List<Screen> screens)
    {
        this.name = theatreName;
        this.city = city;
        this.screens = screens;
    }

    public City getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public List<Screen> getScreens() {
        return screens;
    }
}
