package LLD_Concepts.BehavioralDesignPattern.Observer_Design_Pattern.WeatherStation.Observable;

import LLD_Concepts.BehavioralDesignPattern.Observer_Design_Pattern.WeatherStation.Observer.WeatherObserver;
import LLD_Concepts.BehavioralDesignPattern.Observer_Design_Pattern.WeatherStation.WeatherCondition;

import java.util.ArrayList;
import java.util.List;


// Concrete Observable (Subject)
// WeatherStation - the concrete observable class that holds weather data
public class WeatherStation implements WeatherObservable {

    // List of observers registered for updates
    private List<WeatherObserver> observersList;

    // Observable Data
    private WeatherCondition weatherCondition;

    public WeatherStation()
    {
        this.observersList = new ArrayList<>();
    }

    @Override
    public void addObserver(WeatherObserver observer)
    {
        observersList.add(observer);
    }
    @Override
    public void removeObserver(WeatherObserver observer)
    {
        observersList.remove(observer);
    }

    @Override
    public void notifyAllObservers()
    {
        // Notify each observer about the change in weather data(state)
        for(WeatherObserver observer : observersList)
        {
            observer.update(weatherCondition); // Observer will update its state based on the new data and respond accordingly
        }
    }

    @Override
    public void setWeatherReadings(int temperature, int humidity)
    {
        this.weatherCondition = new WeatherCondition(temperature, humidity);
        notifyAllObservers();
    }
}
