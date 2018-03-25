package com.nivedita.pagination.di.module;

import android.app.Application;
import android.content.Context;

import com.nivedita.pagination.di.scope.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by PUNEETU on 16-03-2018.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        this.mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

}
