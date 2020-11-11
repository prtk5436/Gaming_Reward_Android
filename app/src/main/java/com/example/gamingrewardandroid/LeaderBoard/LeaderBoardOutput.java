package com.example.gamingrewardandroid.LeaderBoard;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeaderBoardOutput {
    @SerializedName("responseStatus")
    @Expose
    private Integer responseStatus;
    @SerializedName("responseMessage")
    @Expose
    private String responseMessage;
    @SerializedName("Top_5_Gamer_Name")
    @Expose
    private List<Top5GamerName> top5GamerName = null;

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

    public List<Top5GamerName> getTop5GamerName() {
        return top5GamerName;
    }

    public void setTop5GamerName(List<Top5GamerName> top5GamerName) {
        this.top5GamerName = top5GamerName;
    }
}
