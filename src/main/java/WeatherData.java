package observerpattern_javautil.src.main.java;

import java.util.Observable;

// Observable is a class, Observer is an interface
public class WeatherData extends Observable {
  private float temperature;
  private float humidity;
  private float pressure;

  public WeatherData() {
  }

  // Note: Observers register themselves using the Observable superclass addObserver() method so we
  // no longer need methods to register, remove, and notify our observers.

  public void measurementsChanged() {
    // This must be called before we notifyObservers()
    setChanged();
    notifyObservers();
  }

  public void setMeasurements(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }

  // This time the observers are going to PULL data from the Observable class
  // rather than get pushed ALL the data (they might not need all of it)
  public float getTemperature() {
    return temperature;
  }

  public float getHumidity() {
    return humidity;
  }

  public float getPressure() {
    return pressure;
  }
}
