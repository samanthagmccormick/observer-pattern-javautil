package observerpattern_javautil.src.main.java;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
  Observable observable;
  private float temperature;
  private float humidity;

  public CurrentConditionsDisplay() {
    this.observable = observable;
    observable.addObserver(this);
  }

  @Override
  public void update(Observable o, Object arg) {
    // Here is where we PULL the data from the Observable (WeatherData) class
    if (o instanceof WeatherData) {
      WeatherData weatherData = (WeatherData) o;
      this.temperature = weatherData.getTemperature();
      this.humidity = weatherData.getHumidity();
      display();
    }
  }

  @Override
  public void display() {
    System.out.println("current conditions: " + temperature + "F degrees and " + humidity + "% " +
        "humidity.");
  }
}
