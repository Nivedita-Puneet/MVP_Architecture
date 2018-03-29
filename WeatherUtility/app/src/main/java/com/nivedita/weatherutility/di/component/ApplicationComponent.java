package com.nivedita.weatherutility.di.component;

import android.app.Application;
import android.content.Context;

import com.nivedita.weatherutility.data.DataManager;
import com.nivedita.weatherutility.data.SharedPrefsHelper;
import com.nivedita.weatherutility.di.ApplicationContext;
import com.nivedita.weatherutility.di.WeatherUtilityApplication;
import com.nivedita.weatherutility.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by PUNEETU on 28-03-2018.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {


    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

}
