package com.example.gamingrewardandroid.Registration;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentRegistrationInput {
    @SerializedName("operation")
    @Expose
    private String operation;
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
    @SerializedName("Flag_Terms_and_condition")
    @Expose
    private String flagTermsAndCondition;
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
    @SerializedName("Preffred_games")
    @Expose
    private String preffredGames;
    @SerializedName("Smartcookie_member_id")
    @Expose
    private String smartcookieMemberId;

    public String getSmc_password() {
        return smc_password;
    }

    public void setSmc_password(String smc_password) {
        this.smc_password = smc_password;
    }

    @SerializedName("smc_password")
    @Expose
    private String smc_password;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
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

    public String getFlagTermsAndCondition() {
        return flagTermsAndCondition;
    }

    public void setFlagTermsAndCondition(String flagTermsAndCondition) {
        this.flagTermsAndCondition = flagTermsAndCondition;
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

}
