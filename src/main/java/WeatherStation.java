package observerpattern_javautil.src.main.java;

public class WeatherStation {

  public static void main(String[] args) {
    // Just passing in fake measurement values for testing
    WeatherData weatherData = new WeatherData();

    CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

    weatherData.setMeasurements(80, 65, 30f);
  }
}
