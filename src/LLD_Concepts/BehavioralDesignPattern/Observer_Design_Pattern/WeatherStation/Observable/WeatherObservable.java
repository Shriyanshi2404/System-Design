package LLD_Concepts.BehavioralDesignPattern.Observer_Design_Pattern.WeatherStation.Observable;

import LLD_Concepts.BehavioralDesignPattern.Observer_Design_Pattern.WeatherStation.Observer.WeatherObserver;

// Observable(Subject) interface
// Defines methods for managing observers and notifying them of changes
public interface WeatherObservable {
    void addObserver(WeatherObserver observer);
    void removeObserver(WeatherObserver observer);
    void notifyAllObservers();
    void setWeatherReadings(int temperature, int humidity);
}
