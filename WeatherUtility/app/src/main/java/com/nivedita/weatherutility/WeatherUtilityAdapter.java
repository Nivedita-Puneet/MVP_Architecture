package com.nivedita.weatherutility;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by PUNEETU on 05-04-2018.
 */

public class WeatherUtilityAdapter extends RecyclerView.Adapter<WeatherUtilityAdapter.WeatherUtilityAdapterViewHolder> {
    private String[] mWeatherData;
    private final WeatherUtilityAdapterOnClickHandler mClickHandler;
    private Context context;

    public WeatherUtilityAdapter(WeatherUtilityAdapterOnClickHandler clickHandler, Context context) {

        mClickHandler = clickHandler;
        this.context = context;
    }

    public interface WeatherUtilityAdapterOnClickHandler {
        void clickListener(String weatherForToday);
    }

    public class WeatherUtilityAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public final TextView mWeatherTextView;

        WeatherUtilityAdapterViewHolder(View view) {
            super(view);
            mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);
            view.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            mClickHandler.clickListener(mWeatherData[getAdapterPosition()]);
        }
    }

    @Override
    public WeatherUtilityAdapter.WeatherUtilityAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int id = R.layout.weather_util_list;
        boolean shouldAttachToParentImmediately = false;

        View view = LayoutInflater.from(context).inflate(id, parent, shouldAttachToParentImmediately);
        return new WeatherUtilityAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherUtilityAdapter.WeatherUtilityAdapterViewHolder holder, int position) {
        holder.mWeatherTextView.setText(mWeatherData[position]);
    }

    @Override
    public int getItemCount() {
        if (null == mWeatherData) {
            return 0;
        } else {
            int length = mWeatherData.length;
            Log.i(WeatherUtilityAdapter.class.getSimpleName(), "" + length);
            return mWeatherData.length;
        }
    }

    public void setWeatherData(String[] weatherData) {
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }

}
