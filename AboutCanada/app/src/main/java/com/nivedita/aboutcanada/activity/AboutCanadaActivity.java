package com.nivedita.aboutcanada.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nivedita.aboutcanada.R;
import com.nivedita.aboutcanada.apiservice.NewsAPIService;
import com.nivedita.aboutcanada.base.BaseApp;
import com.nivedita.aboutcanada.model.News;
import com.nivedita.aboutcanada.util.DividerItemDecoration;
import com.nivedita.aboutcanada.util.VerticalSpaceItemDecoration;

import javax.inject.Inject;

/*Created by Neetu 27-02-2018*/

public class AboutCanadaActivity extends BaseApp implements AboutCanadaView {

    private RecyclerView list;
    @Inject
    public NewsAPIService service;
    ProgressBar progressBar;
    private static final int VERTICAL_ITEM_SPACE = 5;
    TextView emptyView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDeps().inject(this);

        renderView();
        init();

        AboutCanadaPresenter presenter = new AboutCanadaPresenter(service, this);
        presenter.getCategoryList();
    }

    public void renderView() {
        setContentView(R.layout.activity_about_canada);
        list = findViewById(R.id.news_recyclerview);
        progressBar = findViewById(R.id.pb_loading_indicator);
        emptyView = findViewById(R.id.empty_view);
    }

    public void init() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        list.setLayoutManager(new LinearLayoutManager(this));
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        list.setLayoutManager(linearLayoutManager);
        list.setHasFixedSize(true);

        list.addItemDecoration(new VerticalSpaceItemDecoration(VERTICAL_ITEM_SPACE));
        list.addItemDecoration(new DividerItemDecoration(AboutCanadaActivity.this, R.drawable.divider));


    }

    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String appErrorMessage) {

        Toast.makeText(AboutCanadaActivity.this, appErrorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void getNewsListSuccess(News news) {

        System.out.println(news);
        String title = news.getTitle();

        getSupportActionBar().setTitle(title);
        AboutCanadaAdapter adapter = new AboutCanadaAdapter(getApplicationContext(), news.getCategories());
        list.setAdapter(adapter);

    }
}
