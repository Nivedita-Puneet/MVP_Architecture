package com.nivedita.aboutcanada.activity;

import com.nivedita.aboutcanada.apiservice.NetworkError;
import com.nivedita.aboutcanada.apiservice.NewsAPIService;
import com.nivedita.aboutcanada.model.News;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by NEETU on 28-02-2018.
 */

/*Presenter layer in mvp pattern.*/
public class AboutCanadaPresenter {

    private final NewsAPIService service;
    private final AboutCanadaView view;
    private CompositeSubscription subscriptions;

    public AboutCanadaPresenter(NewsAPIService service, AboutCanadaView view) {
        this.service = service;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
    }

    public void getCategoryList() {
        view.showWait();

        Subscription subscription = service.getNewsList(new NewsAPIService.GetNewsListCallback() {
            @Override
            public void onSuccess(News news) {
                view.removeWait();
                view.getNewsListSuccess(news);
            }

            @Override
            public void onError(NetworkError networkError) {
                view.removeWait();
                view.onFailure(networkError.getAppErrorMessage());
            }

        });

        subscriptions.add(subscription);

    }

}
