package com.nivedita.weatherutility.util;

import android.content.Context;
import android.util.Log;

import com.nivedita.weatherutility.model.Temprature;
import com.nivedita.weatherutility.model.Weather;
import com.nivedita.weatherutility.model.WeatherReport;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by PUNEETU on 02-04-2018.
 */

public class WeatherJSONParser {

    private static WeatherJSONParser instance = null;

    final String WEATHERJSON_LIST = "list";
    final String TAG = WeatherJSONParser.class.getSimpleName();

    final String WEATHERJSON_COD = "cod";
    final String WEATHERJSON_CNT = "cnt";
    final String WEATHERJSON_DATE = "dt";

    //Temprature Object
    final String WEATHERJSON_TEMPRATURE = "temp";
    final String WEATHERJSON_DAY = "day";
    final String WEATHERJSON_MINTEMP = "min";
    final String WEATHERJSON_MAXTEMP = "max";
    final String WEATHERJSON_NIGNTTEMP = "night";
    final String WEATHERJSON_EVENINGTEMP = "eve";
    final String WEATHERJSON_MORNINGTEMP = "morn";

    //Get JSON attributes Pressure and Humidity.
    final String WEATHERJSON_PRESSURE = "pressure";
    final String WEATHERJSON_HUMIDITY = "humidity";

    //Get the Weather Report Object
    final String WEATHERJSON_WEATHER = "weather";
    final String WEATHER_REPORT_ID = "id";
    final String WEATHERJSON_MAIN = "main";
    final String WEATHERJSON_DESC = "description";
    final String WEATHERJSON_SPEED = "speed";
    final String WEATHERJSON_DEG = "deg";
    final String WEATHERJSON_CLOUDS = "clouds";
    final String WEATHERJSON_RAIN = "rain";

    protected WeatherJSONParser() {

    }

    public static WeatherJSONParser getInstance() {

        if (instance == null) {
            instance = new WeatherJSONParser();
        }

        return instance;
    }

    public String[] getWeatherAttributesFromJSON(Context context, String weatherJSON) {

        int length = parseWeatherData(context, weatherJSON).size();
        ArrayList<Weather> weatherArrayList = parseWeatherData(context, weatherJSON);

        String[] displayDayForecast = new String[length];

        long localDate = System.currentTimeMillis();
        long utcDate = WeatherDateUtil.getUTCDateFromLocal(localDate);
        long startDay = WeatherDateUtil.normalizeDate(utcDate);

        for (int i = 0; i < length; i++) {

            String date;
            String highAndLow;

            /* These are the values that will be collected */
            long dateTimeMillis;
            double high;
            double low;
            String description;

            dateTimeMillis = startDay + WeatherDateUtil.DAY_IN_MILLIS * i;
            date = WeatherDateUtil.getFriendlyDateString(context, dateTimeMillis, false);

            description = weatherArrayList.get(i).getWeatherReports().get(i).getDescription();

            high = weatherArrayList.get(i).getDailyReport().getMax();
            low = weatherArrayList.get(i).getDailyReport().getMin();
            highAndLow = WeatherUtil.formatHighLows(context, high, low);

            displayDayForecast[i] = date + "-" + description + "-" + highAndLow;
        }

        return displayDayForecast;
    }


    private ArrayList<Weather> parseWeatherData(Context context, String weatherJSON) {

        ArrayList<Weather> weatherArrayList = new ArrayList<>();
        try {
            JSONObject weatherJsonObject = new JSONObject(weatherJSON);
            JSONArray jsonArray = weatherJsonObject.getJSONArray(WEATHERJSON_LIST);

            /*Convert given date to readable format.*/
            long localDate = System.currentTimeMillis();
            long utcDate = WeatherDateUtil.getUTCDateFromLocal(localDate);
            long startDay = WeatherDateUtil.normalizeDate(utcDate);


            for (int i = 0; i < jsonArray.length(); i++) {

                /*Parse and get the following values from restful api to display it to the user*/
                long dateTimeMillis;
                double high;
                double low;
                String description;

                JSONObject dayForecast = jsonArray.getJSONObject(i);

                // Parse and get the temprature object.
                JSONObject jsonObjectTemp = dayForecast.getJSONObject(WEATHERJSON_TEMPRATURE);
                Double dayTemp = jsonObjectTemp.getDouble(WEATHERJSON_DAY);
                Double minTemp = jsonObjectTemp.getDouble(WEATHERJSON_MINTEMP);
                Double maxTemp = jsonObjectTemp.getDouble(WEATHERJSON_MAXTEMP);
                Double nightTemp = jsonObjectTemp.getDouble(WEATHERJSON_NIGNTTEMP);
                Double eveningTemp = jsonObjectTemp.getDouble(WEATHERJSON_EVENINGTEMP);
                Double mornTemp = jsonObjectTemp.getDouble(WEATHERJSON_MORNINGTEMP);

                Temprature temprature = new Temprature(dayTemp, minTemp, maxTemp, nightTemp, eveningTemp, mornTemp);

                //Get the regular weatherReport
                JSONArray weatherReportArray = dayForecast.getJSONArray(WEATHERJSON_WEATHER);
                JSONObject weatherReportObj = weatherReportArray.getJSONObject(0);
                int id = weatherReportObj.getInt(WEATHER_REPORT_ID);
                String mainWeather = weatherReportObj.getString(WEATHERJSON_MAIN);
                String weatherDescription = weatherReportObj.getString(WEATHERJSON_DESC);

                WeatherReport weatherReport = new WeatherReport(id, mainWeather, weatherDescription);
                List<WeatherReport> weatherReports = new LinkedList<>();
                weatherReports.add(weatherReport);

                Weather weather = new Weather(dayForecast.getLong(WEATHERJSON_DATE),
                        temprature,
                        dayForecast.getDouble(WEATHERJSON_PRESSURE),
                        dayForecast.getDouble(WEATHERJSON_HUMIDITY),
                        weatherReports, dayForecast.getDouble(WEATHERJSON_SPEED),
                        dayForecast.getDouble(WEATHERJSON_DEG),
                        dayForecast.getInt(WEATHERJSON_CLOUDS));
                weatherArrayList.add(weather);


            }
        } catch (JSONException e) {
            Log.e(TAG, e.getLocalizedMessage());
        }

        return weatherArrayList;
    }
}
