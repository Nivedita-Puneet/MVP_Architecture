package com.nivedita.weatherutility.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.nivedita.weatherutility.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by PUNEETU on 28-03-2018.
 */


@Singleton
public class DataManager {

    private Context mContext;
    private SharedPrefsHelper mSharedPrefsHelper;

    @Inject
    public DataManager(@ApplicationContext Context context, SharedPrefsHelper mSharedPrefsHelper) {
        mContext = context;
        this.mSharedPrefsHelper = mSharedPrefsHelper;

    }

    public void saveAccessToken(String accessToken) {
        mSharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
    }

    public String getAccessToken() {
        return mSharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
    }
}
