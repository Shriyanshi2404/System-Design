package LLD_Concepts.BehavioralDesignPattern.Observer_Design_Pattern.WeatherStation;

import LLD_Concepts.BehavioralDesignPattern.Observer_Design_Pattern.WeatherStation.Observable.WeatherObservable;
import LLD_Concepts.BehavioralDesignPattern.Observer_Design_Pattern.WeatherStation.Observable.WeatherStation;
import LLD_Concepts.BehavioralDesignPattern.Observer_Design_Pattern.WeatherStation.Observer.CurrentWeatherObserver;
import LLD_Concepts.BehavioralDesignPattern.Observer_Design_Pattern.WeatherStation.Observer.ForecastObserver;
import LLD_Concepts.BehavioralDesignPattern.Observer_Design_Pattern.WeatherStation.Observer.WeatherObserver;

public class WeatherApp {

    public static void main(String[] args)
    {
        // Create the weather station (observable/subject)
        WeatherObservable weatherObservable = new WeatherStation();

        // Create displays (observers)
        WeatherObserver currentWeatherObserver = new CurrentWeatherObserver();
        WeatherObserver forecastDisplayObserver = new ForecastObserver();

        weatherObservable.addObserver(currentWeatherObserver);
        weatherObservable.addObserver(forecastDisplayObserver);

        System.out.println("===>>> Initial Weather Update");
        weatherObservable.setWeatherReadings(35, 65);

        System.out.println("===>>> Second Weather Update");
        weatherObservable.setWeatherReadings(45, 25);

        // Remove forecast display
        weatherObservable.removeObserver(forecastDisplayObserver);

        System.out.println("===>>> Third Weather Update");
        weatherObservable.setWeatherReadings(15, 55);
    }
}
