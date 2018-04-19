package com.nivedita.weatherutility.presenter;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.nivedita.weatherutility.WeatherUtilityLoader;
import com.nivedita.weatherutility.data.DataManager;
import com.nivedita.weatherutility.di.scope.ApplicationContext;
import com.nivedita.weatherutility.model.Weather;
import com.nivedita.weatherutility.view.MVPView;
import com.nivedita.weatherutility.view.WeatherUtilView;

import javax.inject.Inject;

/**
 * Created by PUNEETU on 02-04-2018.
 */

public class WeatherUtilityPresenter extends BasePresenter<WeatherUtilView> implements
        SharedPreferences.OnSharedPreferenceChangeListener {

    private final DataManager mDataManager;
    private final static int SUNSHINE_WEATHER_CODE = 101;
    private Context context;

    @Inject
    public WeatherUtilityPresenter(DataManager mDataManager, Context context) {

        this.mDataManager = mDataManager;
        this.context = context;

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        //TODO: Need to handle change in Shared Preferences.
    }


    @Override
    public void attachView(WeatherUtilView mvpView){
        super.attachView(mvpView);
        //TODO: Need to handle the shared preference changes here.
    }

    @Override
    public void detachView(){
        super.detachView();
        //TODO: Need to handle detaching in  the presenter.
    }
}
