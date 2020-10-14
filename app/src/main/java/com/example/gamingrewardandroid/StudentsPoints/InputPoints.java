package com.example.gamingrewardandroid.StudentsPoints;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InputPoints {

    @SerializedName("operation")
    @Expose
    private String operation;
    @SerializedName("user_id")
    @Expose
    private String id;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
