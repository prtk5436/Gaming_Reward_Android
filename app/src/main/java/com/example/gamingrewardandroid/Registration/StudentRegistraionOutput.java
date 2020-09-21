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
    @SerializedName("mailstatus")
    @Expose
    private String mailstatus;

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

    public String getMailstatus() {
        return mailstatus;
    }

    public void setMailstatus(String mailstatus) {
        this.mailstatus = mailstatus;
    }

  /*  public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
*/
}
