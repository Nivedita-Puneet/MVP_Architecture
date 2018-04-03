package com.nivedita.weatherutility.util;

import android.content.Context;

/**
 * Created by PUNEETU on 30-03-2018.
 */

public class WeatherUtil {

    public static final String TAG = WeatherUtil.class.getSimpleName();

    public static String formatHighLows(Context context, double high, double low) {

        long roundedHigh = Math.round(high);
        long roundedLow = Math.round(low);

        String highLowStr = roundedHigh + "/" + roundedLow;
        return highLowStr;
    }

}
