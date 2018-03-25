package com.nivedita.pagination.data.remote;

import com.nivedita.pagination.model.News;
import com.nivedita.pagination.util.ConstantsUtil;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by PUNEETU on 15-03-2018.
 */

public interface NewsAPI {

    @GET("2iodh4vg0eortkl/facts.json")
    Call<News> getCurrentAffairs();

    class Creator {
        public static NewsAPI newsAPI() {

            Retrofit retrofit = new Retrofit.Builder().client(buildClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(ConstantsUtil.BASE_URL).build();

            return retrofit.create(NewsAPI.class);

        }

        private static OkHttpClient buildClient() {
            return new OkHttpClient
                    .Builder()
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build();
        }
    }

}
