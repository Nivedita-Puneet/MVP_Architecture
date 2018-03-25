package com.nivedita.pagination;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;

import com.nivedita.pagination.di.AppInstance;
import com.nivedita.pagination.di.component.ActivityComponent;
import com.nivedita.pagination.di.component.DaggerActivityComponent;
import com.nivedita.pagination.di.module.ActivityModule;

/**
 * Created by PUNEETU on 20-03-2018.
 */

public class BaseActivity extends AppCompatActivity {

    private ActivityComponent mActivityComponent;
    boolean isLastPage = false;

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

    public ActivityComponent getActivityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this, isLastPage)).applicationComponent(AppInstance.get(this).getComponent()).build();
        }
        return mActivityComponent;
    }

}
