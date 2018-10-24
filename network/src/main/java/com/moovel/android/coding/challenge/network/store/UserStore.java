package com.moovel.android.coding.challenge.network.store;

import com.moovel.android.coding.challenge.network.ClientGenerator;
import com.moovel.android.coding.challenge.network.callbacks.UserCallback;
import com.moovel.android.coding.challenge.network.clients.UserClient;
import com.moovel.android.coding.challenge.network.model.BaseUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserStore {
    private UserStore() {

    }

    public static UserStore getInstance() {
        return new UserStore();
    }

    public void getusers(UserCallback userCallback) {
        UserClient userClient = ClientGenerator.createClient(UserClient.class);
        Call<BaseUser> call = userClient.getUsers();
        call.enqueue(new Callback<BaseUser>() {
            @Override
            public void onResponse(Call<BaseUser> call, Response<BaseUser> response) {
                if (response.isSuccessful()) {
                    userCallback.onSuccess(response.body().getUsers());
                } else {
                    userCallback.onFailure("Something went wrong");
                }
            }

            @Override
            public void onFailure(Call<BaseUser> call, Throwable t) {
                userCallback.onFailure("Something went wrong");
            }
        });

    }

}
