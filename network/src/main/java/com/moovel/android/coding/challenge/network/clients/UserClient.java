package com.moovel.android.coding.challenge.network.clients;

import com.moovel.android.coding.challenge.network.model.BaseUser;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserClient {
    @GET("search/users?q=kotlin&username")
    Call<BaseUser> getUsers();
}
