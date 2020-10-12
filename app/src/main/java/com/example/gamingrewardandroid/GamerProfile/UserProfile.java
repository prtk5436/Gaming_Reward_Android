package com.example.gamingrewardandroid.GamerProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserProfile {


    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Mobile_Number")
    @Expose
    private String mobileNumber;
    @SerializedName("Platform_for_Games")
    @Expose
    private String platformForGames;
    @SerializedName("PassWord")
    @Expose
    private String passWord;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("City")
    @Expose
    private String city;
    @SerializedName("State")
    @Expose
    private String state;
    @SerializedName("Zip_code")
    @Expose
    private String zipCode;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("Flag_Terms_and_condition")
    @Expose
    private String flagTermsAndCondition;
    @SerializedName("Preffred_games")
    @Expose
    private String preffredGames;
    @SerializedName("Smartcookie_member_id")
    @Expose
    private String smartcookieMemberId;
    @SerializedName("registration_date")
    @Expose
    private String registrationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPlatformForGames() {
        return platformForGames;
    }

    public void setPlatformForGames(String platformForGames) {
        this.platformForGames = platformForGames;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFlagTermsAndCondition() {
        return flagTermsAndCondition;
    }

    public void setFlagTermsAndCondition(String flagTermsAndCondition) {
        this.flagTermsAndCondition = flagTermsAndCondition;
    }

    public String getPreffredGames() {
        return preffredGames;
    }

    public void setPreffredGames(String preffredGames) {
        this.preffredGames = preffredGames;
    }

    public String getSmartcookieMemberId() {
        return smartcookieMemberId;
    }

    public void setSmartcookieMemberId(String smartcookieMemberId) {
        this.smartcookieMemberId = smartcookieMemberId;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
}

