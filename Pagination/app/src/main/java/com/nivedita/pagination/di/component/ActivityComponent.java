package com.nivedita.pagination.di.component;

import com.nivedita.pagination.MainActivity;
import com.nivedita.pagination.di.module.ActivityModule;
import com.nivedita.pagination.di.scope.PerActivity;

import dagger.Component;

/**
 * Created by PUNEETU on 16-03-2018.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}

