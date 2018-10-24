package com.moovel.android.coding.challenge.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseUser {
    @SerializedName("total_count")
    private int totalCount;

    @SerializedName("incomplete_results")
    private boolean incompleteResults;

    @SerializedName("items")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }
}
