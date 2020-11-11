package com.example.gamingrewardandroid.LeaderBoard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeaderBoardInput {
    @SerializedName("operation")
    @Expose
    private String operation;
    @SerializedName("type")
    @Expose
    private String type;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
