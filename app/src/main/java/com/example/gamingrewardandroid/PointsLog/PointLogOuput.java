package com.example.gamingrewardandroid.PointsLog;

import com.example.gamingrewardandroid.GamerProfile.UserProfile;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PointLogOuput {

    @SerializedName("responseStatus")
    @Expose
    private Integer responseStatus;
    @SerializedName("responseMessage")
    @Expose
    private String responseMessage;
    @SerializedName("User_Profile")
    @Expose
    private List<UserLog> userProfile = null;

    public Integer getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(Integer responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public List<UserLog> getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(List<UserLog> userProfile) {
        this.userProfile = userProfile;
    }
}

