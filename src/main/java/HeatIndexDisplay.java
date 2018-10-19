package observerpattern_javautil.src.main.java;

import observerpattern.src.main.java.Display;
import observerpattern.src.main.java.Observer;
import observerpattern.src.main.java.Subject;
import observerpattern.src.main.java.WeatherData;

public class HeatIndexDisplay implements Observer, Display {
  private float temperature;
  private float humidity;
  private Subject weatherData;

  public HeatIndexDisplay(WeatherData weatherData) {

    // 1) Store a reference to weatherData object for later
    this.weatherData = weatherData;

    // 2) Register myself as an Observer to the Subject
    weatherData.registerObserver(this);
  }

  @Override
  public void update(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;

    // Now print your info!
    display();
  }

  @Override
  public void display() {
    System.out.println("Heat Index display: " + computeHeatIndex(this.temperature, this.humidity));
  }


  ////////////////////////////////////////////////////////////

  /*
    Formula given to us
    Takes in temperature and relative humidity as parameters
   */
  private float computeHeatIndex(float temperature, float humidity) {
    float index = (float) ((16.923 + (0.185212 * temperature) + (5.37941 * humidity) - (0.100254
        * temperature * humidity) +
        (0.00941695 * (temperature * temperature)) + (0.00728898 * (humidity * humidity)) +
        (0.000345372 * (temperature * temperature * humidity)) - (0.000814971 * (temperature *
        humidity * humidity)) +
        (0.0000102102 * (temperature * temperature * humidity * humidity)) - (0.000038646 *
        (temperature * temperature * temperature)) + (0.0000291583 *
        (humidity * humidity * humidity)) + (0.00000142721 * (temperature * temperature *
        temperature * humidity)) +
        (0.000000197483 * (temperature * humidity * humidity * humidity)) - (0.0000000218429 *
        (temperature * temperature * temperature * humidity * humidity)) +
        0.000000000843296 * (temperature * temperature * humidity * humidity * humidity)) -
        (0.0000000000481975 * (temperature * temperature * temperature * humidity * humidity *
            humidity)));
    return index;
  }


}
