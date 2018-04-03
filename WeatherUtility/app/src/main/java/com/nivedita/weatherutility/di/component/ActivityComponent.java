package com.nivedita.weatherutility.di.component;

import com.nivedita.weatherutility.WeatherUtility;
import com.nivedita.weatherutility.di.scope.PerActivity;
import com.nivedita.weatherutility.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by PUNEETU on 28-03-2018.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(WeatherUtility weatherUtility);
}
