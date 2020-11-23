package com.example.gamingrewardandroid.SmartcookieRegistration;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SmcOutput {

    @SerializedName("responseStatus")
    @Expose
    private Integer responseStatus;
    @SerializedName("responseMessage")
    @Expose
    private String responseMessage;
    @SerializedName("posts")
    @Expose
    private Object posts;

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

    public Object getPosts() {
        return posts;
    }

    public void setPosts(Object posts) {
        this.posts = posts;
    }
}
