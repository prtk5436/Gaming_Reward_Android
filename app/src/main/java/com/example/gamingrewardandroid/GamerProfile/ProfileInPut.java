package com.example.gamingrewardandroid.GamerProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileInPut {
    @SerializedName("operation")
    @Expose
    private String operation;
    @SerializedName("user_id")
    @Expose
    private String userId;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
