package com.example.gamingrewardandroid.PointsForm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReawardParameterOutput {

    @SerializedName("responseStatus")
    @Expose
    private Integer responseStatus;
    @SerializedName("responseMessage")
    @Expose
    private String responseMessage;
    @SerializedName("Game_Parameters_List")
    @Expose
    private List<String> gameParametersList = null;

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

    public List<String> getGameParametersList() {
        return gameParametersList;
    }

    public void setGameParametersList(List<String> gameParametersList) {
        this.gameParametersList = gameParametersList;
    }
}
