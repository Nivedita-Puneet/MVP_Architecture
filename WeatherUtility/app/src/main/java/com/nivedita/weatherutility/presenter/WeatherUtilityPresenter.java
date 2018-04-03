package com.nivedita.weatherutility.presenter;

import android.app.LoaderManager;
import android.content.Loader;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.nivedita.weatherutility.data.DataManager;
import com.nivedita.weatherutility.model.Weather;

import javax.inject.Inject;

/**
 * Created by PUNEETU on 02-04-2018.
 */

public class WeatherUtilityPresenter implements
        SharedPreferences.OnSharedPreferenceChangeListener, LoaderManager.LoaderCallbacks<Weather> {

    private final DataManager mDataManager;

    @Inject
    public WeatherUtilityPresenter(DataManager mDataManager) {

        this.mDataManager = mDataManager;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

    }

    @Override
    public Loader<Weather> onCreateLoader(int i, Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Weather> loader, Weather weather) {

    }

    @Override
    public void onLoaderReset(Loader<Weather> loader) {

    }
}
