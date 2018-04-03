package com.nivedita.weatherutility.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.nivedita.weatherutility.di.scope.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by PUNEETU on 28-03-2018.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application mApplication){
        this.mApplication = mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext(){
        return mApplication;
    }

    @Provides
    Application provideApplication(){
        return mApplication;
    }

    @Provides
    SharedPreferences provideSharedPrefs(){
        return mApplication.getSharedPreferences("weather-prefs", Context.MODE_PRIVATE);
    }
}
