package com.nivedita.pagination.di.component;

import android.app.Application;
import android.content.Context;

import com.nivedita.pagination.data.remote.DataManager;
import com.nivedita.pagination.di.module.ApplicationModule;
import com.nivedita.pagination.di.module.NetworkModule;
import com.nivedita.pagination.di.scope.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by PUNEETU on 16-03-2018.
 */

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    Application application();

    @ApplicationContext
    Context context();

    DataManager dataManager();
}
