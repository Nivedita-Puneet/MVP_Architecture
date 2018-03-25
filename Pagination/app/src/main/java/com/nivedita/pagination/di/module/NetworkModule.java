package com.nivedita.pagination.di.module;

import com.nivedita.pagination.data.remote.NewsAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by PUNEETU on 16-03-2018.
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    NewsAPI provideNewsAPI() {

        return NewsAPI.Creator.newsAPI();
    }

}
