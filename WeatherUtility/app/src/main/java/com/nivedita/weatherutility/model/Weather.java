package com.nivedita.weatherutility.model;

import java.util.List;

/**
 * Created by PUNEETU on 28-03-2018.
 */

public class Weather {


    private long date;
    private Temprature dailyReport;
    private double pressure;
    private double humidity;
    private List<WeatherReport> weatherReports;
    private double speed;
    private double degree;
    private int clouds;

    public Weather(long date, Temprature dailyReport,
                   double pressure, double humidity,
                   List<WeatherReport> weatherReports,
                   double speed, double degree, int clouds) {
        this.date = date;
        this.dailyReport = dailyReport;
        this.pressure = pressure;
        this.humidity = humidity;
        this.weatherReports = weatherReports;
        this.speed = speed;
        this.degree = degree;
        this.clouds = clouds;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public Temprature getDailyReport() {
        return dailyReport;
    }

    public void setDailyReport(Temprature dailyReport) {
        this.dailyReport = dailyReport;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public List<WeatherReport> getWeatherReports() {
        return weatherReports;
    }

    public void setWeatherReports(List<WeatherReport> weatherReports) {
        this.weatherReports = weatherReports;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }


}
