package com.nivedita.weatherutility;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.preference.PreferenceScreen;

import com.nivedita.weatherutility.data.SharedPrefsHelper;
import com.nivedita.weatherutility.di.WeatherUtilityApplication;
import com.nivedita.weatherutility.util.WeatherDateUtil;

import javax.inject.Inject;

/**
 * Created by PUNEETU on 28-03-2018.
 */

public class PreferenceFragment extends BaseFragment implements
        PreferenceScreen.OnPreferenceChangeListener, SharedPreferences.OnSharedPreferenceChangeListener {

    @Inject
    SharedPrefsHelper sharedPrefsHelper;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        // Add general preferences defined in XML fi
        // le.
        addPreferencesFromResource(R.xml.pref_home);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        int count = preferenceScreen.getPreferenceCount();


        for (int i = 0; i < count; i++) {

            Preference preference = preferenceScreen.getPreference(i);
            if (!(preference instanceof CheckBoxPreference)) {

                String value = sharedPrefsHelper.get(preference.getKey(), "");
                setPreferenceSummary(preference, value);

            }
        }
    }

    private void bindPreferenceSummaryToValue(Preference preference) {

        preference.setOnPreferenceChangeListener(this);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object value) {

        String location = value.toString();
        if (!WeatherDateUtil.isNumeric(location)) {

            preference.setSummary(location);
            setPreferenceSummary(preference, location);
        }

        return true;
    }


    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        Preference preference = findPreference(key);

        if (sharedPreferences != null) {

            String value = sharedPreferences.getString(preference.getKey(), "");
            setPreferenceSummary(preference, value);
        }
    }

    private void setPreferenceSummary(Preference preference, String value) {
        if (preference instanceof EditTextPreference) {

            preference.setSummary(value);
        }
    }
}
