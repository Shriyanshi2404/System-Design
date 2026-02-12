package LLD_Concepts.BehavioralDesignPattern.Observer_Design_Pattern.WeatherStation.Observer;

import LLD_Concepts.BehavioralDesignPattern.Observer_Design_Pattern.WeatherStation.WeatherCondition;

// Concrete Observer - Forecast Weather Observer
public class ForecastObserver implements WeatherObserver {

    // ForecastDisplay implements the update method in its own way
    @Override
    public void update(WeatherCondition weatherCondition)
    {
        System.out.println("Updating weather data to do some analytics");
        display(weatherCondition);
    }

    // Display the forecast
    public void display(WeatherCondition weatherCondition) {
        System.out.println("Forecast Details:: " + weatherCondition.toString());
    }
}
