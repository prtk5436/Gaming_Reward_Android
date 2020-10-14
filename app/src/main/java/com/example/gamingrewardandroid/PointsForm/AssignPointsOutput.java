package com.example.gamingrewardandroid.PointsForm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AssignPointsOutput {
    @SerializedName("responseStatus")
    @Expose
    private Integer responseStatus;
    @SerializedName("responseMessage")
    @Expose
    private String responseMessage;
    @SerializedName("Points_Earned")
    @Expose
    private Integer pointsEarned;

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

    public Integer getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(Integer pointsEarned) {
        this.pointsEarned = pointsEarned;
    }
}
