package com.nivedita.pagination.data.remote;

import com.nivedita.pagination.model.News;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;

/**
 * Created by PUNEETU on 16-03-2018.
 */

@Singleton
public class DataManager {

    private final NewsAPI newsAPI;
    public static final String TAG = DataManager.class.getSimpleName();

    @Inject
    public DataManager(NewsAPI newsAPI) {
        this.newsAPI = newsAPI;
    }

    public Call<News> getResponseFromAPI() {
        return callCurrentAffairs();
    }

    private Call<News> callCurrentAffairs() {
        return newsAPI.getCurrentAffairs();
    }
}
