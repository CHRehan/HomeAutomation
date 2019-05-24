package com.waheed.home.auto.mation.web_services;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    private static Retrofit retrofit = null;
    public static String BASE_URL = "";

/*
    public static Retrofit getClient() {


        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);


        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(logging)

                .build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())

                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
*/

    public static Retrofit getClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient build = new OkHttpClient.
                Builder()
                .addInterceptor(logging)
                .build();
        if (retrofit == null) {
            Retrofit.Builder builder = new Retrofit.Builder();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(BASE_URL);
            stringBuilder.append("/");
            retrofit = builder.baseUrl(stringBuilder.toString()).addConverterFactory(GsonConverterFactory.create()).client(build).build();
        }
        return retrofit;
    }

}
