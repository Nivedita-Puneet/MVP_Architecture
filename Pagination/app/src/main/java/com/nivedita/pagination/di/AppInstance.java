package com.nivedita.pagination.di;

import android.app.Application;
import android.content.Context;

import com.nivedita.pagination.di.component.ApplicationComponent;
import com.nivedita.pagination.di.component.DaggerApplicationComponent;
import com.nivedita.pagination.di.module.ApplicationModule;
import com.nivedita.pagination.di.module.NetworkModule;

import dagger.internal.DaggerCollections;

/**
 * Created by PUNEETU on 16-03-2018.
 */

public class AppInstance extends Application {

    ApplicationComponent applicationComponent;


    @Override
    public void onCreate() {

        super.onCreate();


    }

    public static AppInstance get(Context context) {

        return (AppInstance) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {

        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .networkModule(new NetworkModule()).build();
        }

        return applicationComponent;
    }

    public void setApplicationComponent(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }

}
