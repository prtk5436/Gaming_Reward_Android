package com.example.gamingrewardandroid.LoginStudent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginInput {
    @SerializedName("operation")
    @Expose
    private String operation;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Mobile_Number")
    @Expose
    private String mobileNumber;
    @SerializedName("PassWord")
    @Expose
    private String passWord;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
