package LLD_Concepts.BehavioralDesignPattern.Observer_Design_Pattern.WeatherStation.Observer;

import LLD_Concepts.BehavioralDesignPattern.Observer_Design_Pattern.WeatherStation.WeatherCondition;

// Concrete Observer - Current Weather Observer
public class CurrentWeatherObserver implements WeatherObserver {

    // CurrentWeatherDisplay implements the update method in its own way
    @Override
    public void update(WeatherCondition weatherCondition)
    {
        System.out.println("Updating weather data to do some analytics");
        display(weatherCondition);
    }

    // Display the current weather
    public void display(WeatherCondition weatherCondition) {
        System.out.println("Current weather Details:: " + weatherCondition.toString());
    }

}
