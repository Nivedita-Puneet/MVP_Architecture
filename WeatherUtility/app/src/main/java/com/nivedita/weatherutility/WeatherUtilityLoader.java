package com.nivedita.weatherutility;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.nivedita.weatherutility.data.DataManager;

import javax.inject.Inject;

/**
 * Created by PUNEETU on 05-04-2018.
 */

public class WeatherUtilityLoader extends AsyncTaskLoader<String[]> {

    private Context context;
    String[] mWeatherData = null;

    @Inject
    DataManager mDataManager;

    public WeatherUtilityLoader(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onStartLoading() {

        super.onStartLoading();
        if (mWeatherData != null) {
            deliverResult(mWeatherData);
        } else {
            //TODO: handle loading of progress bar.
            forceLoad();
        }
    }

    @Override
    public String[] loadInBackground() {

        String preferredLocation = mDataManager.getLocation();
        String[] parsedWeatherJson = mDataManager.getWeatherUpdates(preferredLocation);
        return parsedWeatherJson;
    }
}
