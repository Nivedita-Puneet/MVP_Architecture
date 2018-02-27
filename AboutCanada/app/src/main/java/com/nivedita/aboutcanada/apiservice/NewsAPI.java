package com.nivedita.aboutcanada.apiservice;

import com.nivedita.aboutcanada.model.News;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by NEETU on 27-02-2018.
 */

/*Create an Observable using Retrofit GET and
rx to consume api and serialize JSON response*/
public interface NewsAPI {

    @GET("2iodh4vg0eortkl/facts.json")
    Observable<News> getNews();
}
