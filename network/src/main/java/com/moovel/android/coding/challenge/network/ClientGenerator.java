package com.moovel.android.coding.challenge.network;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by anilpathak on 05/09/17.
 * Creating instance of retrofit to make url calls
 */

public class ClientGenerator {
    private static Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create();

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(
                    new OkHttpClient.Builder()
                            .retryOnConnectionFailure(true)
                            .build()
            )
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();


    public static <S> S createClient(
            Class<S> clientClass) {

        return retrofit.create(clientClass);
    }
}
