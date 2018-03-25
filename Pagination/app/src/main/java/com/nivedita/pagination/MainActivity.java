package com.nivedita.pagination;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nivedita.pagination.model.News;
import com.nivedita.pagination.model.Row;
import com.nivedita.pagination.presenter.MainPresenter;
import com.nivedita.pagination.util.LogNetworkError;
import com.nivedita.pagination.view.MainMVPView;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainMVPView {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    TextView emptyView;

    LinearLayoutManager linearLayoutManager;

    @Inject
    CurrentAffairsAdapter currentAffairsAdapter;

    @Inject
    MainPresenter mainPresenter;

    private List<Row> rows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(MainActivity.this);
        initializeControls();
    }

    private void initializeControls() {

        recyclerView = (RecyclerView) findViewById(R.id.main_recycler);
        progressBar = (ProgressBar) findViewById(R.id.main_progress);
        emptyView = (TextView) findViewById(R.id.empty_view);

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(currentAffairsAdapter);
        mainPresenter.attachView(this);

        recyclerView.addOnScrollListener(new PaginationScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int currentPage, int totalItemCount, View view) {
                if (!mainPresenter.isLastPage()) {

                    mainPresenter.loadAndPaginateFromAPI();
                }

            }
        });

        mainPresenter.loadFirstPageFromAPI();
    }

    @Override
    public void showLoading() {

        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void removeLoading() {

        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showCurrentAffairs(News news) {

        rows = news.getRows();
        emptyView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        currentAffairsAdapter.addAll(rows);
        currentAffairsAdapter.notifyDataSetChanged();

    }

    @Override
    public void noCurrentAffairs() {

        recyclerView.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);

    }

    @Override
    public void showError(LogNetworkError logNetworkError) {

        progressBar.setVisibility(View.INVISIBLE);
        Toast.makeText(this, logNetworkError.getAppErrorMessage(), Toast.LENGTH_LONG).show();
    }


}
