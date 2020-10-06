
package com.example.gamingrewardandroid.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("Sports Name")
    @Expose
    private String sportsName;
    @SerializedName("Year")
    @Expose
    private String year;
    @SerializedName("FullName")
    @Expose
    private String FullName;

    @SerializedName("Points")
    @Expose
    private String Points;

    @SerializedName("Category")
    @Expose
    private String category;

    public String getPoints() {
        return Points;
    }

    public void setPoints(String points) {
        Points = points;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getSportsName() {
        return sportsName;
    }

    public void setSportsName(String sportsName) {
        this.sportsName = sportsName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
