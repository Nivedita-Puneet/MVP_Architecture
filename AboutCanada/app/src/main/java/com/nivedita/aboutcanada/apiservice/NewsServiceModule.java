package com.nivedita.aboutcanada.apiservice;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import okhttp3.Cache;

import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by NEETU on 27-02-2018.
 */

/*This module will be used by DI layer in order to create clean MVP architecture and adapt scalable architecture.*/

@Module
public class NewsServiceModule {

    File cacheFile;

    public NewsServiceModule(File cacheFile) {
        this.cacheFile = cacheFile;
    }

    public NewsServiceModule() {

    }

    @Provides
    @Singleton
    Retrofit provideCall() {
        Cache cache = null;
        try {
            cache = new Cache(cacheFile, 10 * 1024 * 1024);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Retrofit.Builder()
                .baseUrl("https://dl.dropboxusercontent.com/s/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public NewsAPI providesNetworkService(
            Retrofit retrofit) {
        return retrofit.create(NewsAPI.class);
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public NewsAPIService providesService(
            NewsAPI newsAPI) {
        return new NewsAPIService(newsAPI);
    }


}
