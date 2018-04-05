package com.nivedita.weatherutility.presenter;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.nivedita.weatherutility.WeatherUtilityLoader;
import com.nivedita.weatherutility.data.DataManager;
import com.nivedita.weatherutility.di.scope.ApplicationContext;
import com.nivedita.weatherutility.model.Weather;

import javax.inject.Inject;

/**
 * Created by PUNEETU on 02-04-2018.
 */

public class WeatherUtilityPresenter implements
        SharedPreferences.OnSharedPreferenceChangeListener, LoaderManager.LoaderCallbacks<String[]> {

    private final DataManager mDataManager;
    private final static int SUNSHINE_WEATHER_CODE = 101;
    private Context context;

    @Inject
    @ApplicationContext
    public WeatherUtilityPresenter(DataManager mDataManager, Context context) {

        this.mDataManager = mDataManager;
        this.context = context;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

    }

    @Override
    public Loader<String[]> onCreateLoader(int i, Bundle bundle) {
        return new WeatherUtilityLoader(this.context);
    }

    @Override
    public void onLoadFinished(Loader<String[]> loader, String[] weather) {

        if(weather != null){
            //TODO: Use a recyclerview adapter and set the data.
        }
    }

    @Override
    public void onLoaderReset(Loader<String[]> loader) {

    }
}
