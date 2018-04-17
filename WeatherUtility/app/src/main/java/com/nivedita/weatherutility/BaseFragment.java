package com.nivedita.weatherutility;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.nivedita.weatherutility.di.WeatherUtilityApplication;
import com.nivedita.weatherutility.di.component.ActivityComponent;
import com.nivedita.weatherutility.di.component.ApplicationComponent;
import com.nivedita.weatherutility.di.component.DaggerActivityComponent;
import com.nivedita.weatherutility.di.component.DaggerApplicationComponent;
import com.nivedita.weatherutility.di.module.ActivityModule;
import com.nivedita.weatherutility.di.module.ApplicationModule;

/**
 * Created by PUNEETU on 16-04-2018.
 */

public class BaseFragment extends PreferenceFragmentCompat {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

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

    public ApplicationComponent getApplicationComponent() {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.
                    builder()
                    .applicationModule(new ApplicationModule((WeatherUtilityApplication) getContext()))
                    .build();
        }

        return applicationComponent;
    }
}
