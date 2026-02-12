package LLD_Concepts.BehavioralDesignPattern.Observer_Design_Pattern.WeatherStation.Observer;

import LLD_Concepts.BehavioralDesignPattern.Observer_Design_Pattern.WeatherStation.WeatherCondition;

public interface WeatherObserver {

    void update(WeatherCondition weatherCondition);
}
