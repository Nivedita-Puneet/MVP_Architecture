package com.nivedita.weatherutility.data;

import android.content.Context;
import android.util.Log;

import com.nivedita.weatherutility.R;
import com.nivedita.weatherutility.data.local.NetworkUtils;
import com.nivedita.weatherutility.di.scope.ApplicationContext;
import com.nivedita.weatherutility.util.WeatherJSONParser;

import java.io.IOException;
import java.net.URL;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by PUNEETU on 28-03-2018.
 */


@Singleton
public class DataManager {

    private Context mContext;
    private SharedPrefsHelper mSharedPrefsHelper;

    @Inject
    public DataManager(@ApplicationContext Context context, SharedPrefsHelper mSharedPrefsHelper) {
        mContext = context;
        this.mSharedPrefsHelper = mSharedPrefsHelper;

    }

    public void saveLocation(String location) {
        mSharedPrefsHelper.put(mContext.getResources().getString(R.string.pref_location_key), location);
    }

    public String getLocation() {
        return mSharedPrefsHelper.get(mContext.getResources().getString(R.string.pref_location_key),
                mContext.getResources().getString(R.string.pref_location_default));
    }

    public String[] getWeatherUpdates(String location) {

        URL httpWeatherUrl = NetworkUtils.buildUrl(location);
        WeatherJSONParser jsonParser = WeatherJSONParser.getInstance();
        String[] parsedWeatherJSON = null;

        try {
            String httpWeatherJSON = NetworkUtils.getResponseFromHttpURL(httpWeatherUrl);
            parsedWeatherJSON = jsonParser.getWeatherAttributesFromJSON(mContext, httpWeatherJSON);

        } catch (IOException e) {
            Log.e(DataManager.class.getSimpleName(), e.getLocalizedMessage());
        }

        return parsedWeatherJSON;
    }
}
