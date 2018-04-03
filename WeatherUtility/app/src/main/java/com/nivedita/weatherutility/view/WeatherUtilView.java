package com.nivedita.weatherutility.view;

import com.nivedita.weatherutility.model.Weather;

/**
 * Created by NEETU on 30-03-2018.
 */

public interface WeatherUtilView extends MVPView {

    void showWeatherReports(Weather weather);

    void noWeatherReport();

    void showWait();

    void removeWait();

    void showError(Error error);
}
