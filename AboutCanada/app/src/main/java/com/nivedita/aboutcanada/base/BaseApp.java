package com.nivedita.aboutcanada.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.nivedita.aboutcanada.di.Deps;

import com.nivedita.aboutcanada.apiservice.NewsServiceModule;
import com.nivedita.aboutcanada.di.DaggerDeps;
import com.nivedita.aboutcanada.di.Deps;

import java.io.File;

/**
 * Created by Neetu on 6/28/16.
 */
public class BaseApp extends AppCompatActivity {
    Deps deps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "responses");
        deps = DaggerDeps.builder().newsServiceModule(new NewsServiceModule(cacheFile)).build();

    }

    public Deps getDeps() {
        return deps;
    }
}