package com.moovel.android.coding.challenge.network.callbacks;

import com.moovel.android.coding.challenge.network.model.User;

import java.util.List;

public interface UserCallback {

    void onSuccess(List<User> users);

    void onFailure(String error);
}
