package com.nivedita.aboutcanada.di;

import com.nivedita.aboutcanada.activity.AboutCanadaActivity;
import com.nivedita.aboutcanada.apiservice.NewsServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by NEETU on 27-02-2018.
 */

@Singleton
@Component(modules = {NewsServiceModule.class})

public interface Deps {

    void inject(AboutCanadaActivity aboutCanadaActivity);
}
