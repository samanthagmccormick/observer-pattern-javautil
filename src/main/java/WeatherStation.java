package observerpattern_javautil.src.main.java;

public class WeatherStation {

  public static void main(String[] args) {
    // Just passing in fake measurement values for testing
    WeatherData weatherData = new WeatherData();

    CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

    // Calling this lets the observers know that the data has been updated. It also calls display()
    weatherData.setMeasurements(80, 65, 30f);
  }
}
