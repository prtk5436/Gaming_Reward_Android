package com.example.gamingrewardandroid.LoginStudent;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginStudentInput {
    @SerializedName("long")
    @Expose
    private String _long;
    @SerializedName("College_Code")
    @Expose
    private String collegeCode;
    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("device_details")
    @Expose
    private String deviceDetails;
    @SerializedName("device_type")
    @Expose
    private String deviceType;
    @SerializedName("ip_address")
    @Expose
    private String ipAddress;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("platform_OS")
    @Expose
    private String platformOS;
    @SerializedName("User_Name")
    @Expose
    private String userName;
    @SerializedName("User_Pass")
    @Expose
    private String userPass;
    @SerializedName("User_Type")
    @Expose
    private String userType;

    public String getLong() {
        return _long;
    }

    public void setLong(String _long) {
        this._long = _long;
    }

    public String getCollegeCode() {
        return collegeCode;
    }

    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDeviceDetails() {
        return deviceDetails;
    }

    public void setDeviceDetails(String deviceDetails) {
        this.deviceDetails = deviceDetails;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPlatformOS() {
        return platformOS;
    }

    public void setPlatformOS(String platformOS) {
        this.platformOS = platformOS;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
