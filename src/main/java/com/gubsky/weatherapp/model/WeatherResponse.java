package com.gubsky.weatherapp.model;

public class WeatherResponse {
    private double temperature;
    private String condition;
    private double windSpeed;

    public WeatherResponse() {
    }

    public WeatherResponse(double temperature, String condition, double windSpeed) {
        this.temperature = temperature;
        this.condition = condition;
        this.windSpeed = windSpeed;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
}
