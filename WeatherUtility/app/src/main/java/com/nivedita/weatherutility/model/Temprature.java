package com.nivedita.weatherutility.model;

/**
 * Created by PUNEETU on 28-03-2018.
 */

public class Temprature {

    private double day;
    private double min;
    private double max;
    private double night;
    private double evening;
    private double morn;

    public Temprature(double day, double min, double max, double night, double evening, double morn) {
        this.day = day;
        this.min = min;
        this.max = max;
        this.night = night;
        this.evening = evening;
        this.morn = morn;
    }

    public double getDay() {
        return day;
    }

    public void setDay(double day) {
        this.day = day;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getNight() {
        return night;
    }

    public void setNight(double night) {
        this.night = night;
    }

    public double getEvening() {
        return evening;
    }

    public void setEvening(double evening) {
        this.evening = evening;
    }

    public double getMorn() {
        return morn;
    }

    public void setMorn(double morn) {
        this.morn = morn;
    }

}
