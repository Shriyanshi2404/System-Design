package LLD_Concepts.BehavioralDesignPattern.Observer_Design_Pattern.WeatherStation;

public class WeatherCondition {

    private int temperature;
    private int humidity;

    public WeatherCondition (int temp, int humidity)
    {
        this.temperature = temp;
        this.humidity = humidity;
    }

    public int getTemperature()
    {
        return temperature;
    }

    public int getHumidity()
    {
        return humidity;
    }

    @Override
    public String toString() {
        return "WeatherStation{" + "temperature=" + temperature + ", humidity=" + humidity + "}";
    }

}
