package com.example.gamingrewardandroid.Registration;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentRegistraionOutput {

    @SerializedName("responseStatus")
    @Expose
    private Integer responseStatus;
    @SerializedName("responseMessage")
    @Expose
    private String responseMessage;

    /* @SerializedName("posts")
    @Expose
    private List<Post> posts = null;*/

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

}
