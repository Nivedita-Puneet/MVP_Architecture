package com.nivedita.weatherutility;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.nivedita.weatherutility.presenter.WeatherUtilityPresenter;
import com.nivedita.weatherutility.view.WeatherUtilView;

import javax.inject.Inject;

public class WeatherUtility extends BaseActivity implements WeatherUtilView, LoaderManager.LoaderCallbacks<String[]> {

    @Inject
    WeatherUtilityPresenter weatherUtilityPresenter;

    RecyclerView weatherUtilRecyclerView;
    ProgressBar progressBar;
    LinearLayoutManager linearLayoutManager;
    WeatherUtilityAdapter weatherUtilityAdapter;

    private static final int SUNSHINE_WEATHER_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_utility);

        initalizeControls();
    }

    private void initalizeControls() {

        /*Use the dagger component and inject to the home activity*/
        getSupportLoaderManager().initLoader(SUNSHINE_WEATHER_CODE, null, WeatherUtility.this);

        getActivityComponent().inject(WeatherUtility.this);
        /*Initialize and instantiate the controls.*/
        weatherUtilRecyclerView = findViewById(R.id.recyclerview_forecast);
        progressBar = findViewById(R.id.pb_loading_indicator);

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        weatherUtilRecyclerView.setLayoutManager(linearLayoutManager);

        weatherUtilRecyclerView.setItemAnimator(new DefaultItemAnimator());

        /*Initalize the adapter and instantiate it.*/
        weatherUtilityAdapter = new WeatherUtilityAdapter(new WeatherUtilityAdapter.WeatherUtilityAdapterOnClickHandler() {
            @Override
            public void clickListener(String weatherForToday) {

                //TODO: Need to add listener on tap and navigate to the detail activity.
            }
        }, WeatherUtility.this);

        weatherUtilRecyclerView.setAdapter(weatherUtilityAdapter);
        weatherUtilityPresenter.attachView(this);
    }

    @Override
    public void showWeatherReports(String[] weather) {


    }

    @Override
    public void noWeatherReport() {

    }

    @Override
    public void showWait() {

    }

    @Override
    public void removeWait() {

    }

    @Override
    public void showError(Error error) {

    }

    @Override
    public Loader<String[]> onCreateLoader(int id, Bundle args) {
        return new WeatherUtilityLoader(WeatherUtility.this);
    }

    @Override
    public void onLoadFinished(Loader<String[]> loader, String[] data) {

        this.removeWait();
        if (data != null) {
            weatherUtilityAdapter.setWeatherData(data);
            weatherUtilityAdapter.notifyDataSetChanged();
        } else {

            //TODO: Need to handle the error if there is an error in data.
        }
    }

    @Override
    public void onLoaderReset(Loader<String[]> loader) {

    }
}
