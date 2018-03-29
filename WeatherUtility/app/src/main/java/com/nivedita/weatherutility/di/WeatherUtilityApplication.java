package com.nivedita.weatherutility.di;

import android.app.Application;
import android.content.Context;

import com.nivedita.weatherutility.data.DataManager;
import com.nivedita.weatherutility.di.component.ApplicationComponent;
import com.nivedita.weatherutility.di.component.DaggerApplicationComponent;
import com.nivedita.weatherutility.di.module.ApplicationModule;

import javax.inject.Inject;

/**
 * Created by PUNEETU on 29-03-2018.
 */

public class WeatherUtilityApplication extends Application {

    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();


    }

    public static WeatherUtilityApplication get(Context context) {

        return (WeatherUtilityApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {

        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }

        return applicationComponent;
    }


}
