package com.nivedita.aboutcanada.apiservice;

import com.nivedita.aboutcanada.model.News;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by NEETU on 27-02-2018.
 */

/*API service and rx subscription used to handle Async programming*/
public class NewsAPIService {

    private final NewsAPI newsAPI;

    public NewsAPIService(NewsAPI newsAPI) {
        this.newsAPI = newsAPI;
    }
    /*handle the success response and handle the network error */
    public Subscription getNewsList(final GetNewsListCallback callback) {

        return newsAPI.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends News>>() {
                    @Override
                    public Observable<? extends News> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<News>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));

                    }

                    @Override
                    public void onNext(News response) {
                        callback.onSuccess(response);

                    }
                });
    }

    public interface GetNewsListCallback {
        void onSuccess(News cityListResponse);

        void onError(NetworkError networkError);
    }

}
