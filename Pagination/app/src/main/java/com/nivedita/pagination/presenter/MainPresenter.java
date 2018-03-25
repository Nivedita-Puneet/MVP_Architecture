package com.nivedita.pagination.presenter;


import android.os.Handler;

import com.nivedita.pagination.data.remote.DataManager;
import com.nivedita.pagination.model.News;
import com.nivedita.pagination.model.Row;
import com.nivedita.pagination.util.LogNetworkError;
import com.nivedita.pagination.view.AdapterView;
import com.nivedita.pagination.view.MainMVPView;

import java.util.List;


import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by PUNEETU on 18-03-2018.
 */

public class MainPresenter extends BasePresenter<MainMVPView> {

    private final DataManager mDataManager;
    private static final String TAG = MainPresenter.class.getSimpleName();
    private static final int PAGE_START = 1;
    private int TOTAL_PAGES = 5;
    private int currentPage = PAGE_START;


    private boolean isLastPage;


    Handler handler;

    @Inject
    public MainPresenter(DataManager mDataManager, boolean isLastPage) {
        this.mDataManager = mDataManager;
        this.isLastPage = isLastPage;

    }

    @Override
    public void attachView(MainMVPView mainMVPView) {
        super.attachView(mainMVPView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void loadAndPaginateFromAPI() {

        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (currentPage++ < 5) {

                    loadNextPage();
                }
            }
        }, 1000);

    }

   /* private List<Row> fetchResults(Response<News> response) {

        News news = response.body();
        return news.getRows();
    }*/

    public void loadFirstPageFromAPI() {
        mDataManager.getResponseFromAPI().enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                getMvpView().removeLoading();
                if (!response.body().getRows().isEmpty()) {

                    getMvpView().showCurrentAffairs(response.body());
                } else {

                    getMvpView().noCurrentAffairs();
                }


                isLastPage = false;
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

                getMvpView().showError(new LogNetworkError(t));
            }
        });
    }

    private void loadNextPage() {

        mDataManager.getResponseFromAPI().enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                if (!response.body().getRows().isEmpty()) {
                    getMvpView().showCurrentAffairs(response.body());
                } else {
                    getMvpView().noCurrentAffairs();
                }


                if (currentPage == TOTAL_PAGES) {
                    isLastPage = true;
                } else {
                    isLastPage = false;
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

                getMvpView().showError(new LogNetworkError(t));
            }
        });

    }

    public boolean isLastPage() {
        return isLastPage;
    }

}
