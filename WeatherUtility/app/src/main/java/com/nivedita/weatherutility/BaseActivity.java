package com.nivedita.weatherutility;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;

import com.nivedita.weatherutility.di.WeatherUtilityApplication;
import com.nivedita.weatherutility.di.component.ActivityComponent;
import com.nivedita.weatherutility.di.component.DaggerActivityComponent;
import com.nivedita.weatherutility.di.module.ActivityModule;

/**
 * Created by PUNEETU on 29-03-2018.
 */

public class BaseActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
        }
    }

    public ActivityComponent getActivityComponent(){
        if(activityComponent == null){
            activityComponent = DaggerActivityComponent.
                    builder().activityModule(new ActivityModule(this))
                    .applicationComponent(WeatherUtilityApplication.get(this).getComponent()).build();
        }

        return activityComponent;
    }

}
