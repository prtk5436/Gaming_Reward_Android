package com.example.gamingrewardandroid.StudentsPoints;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PointsModel {
    @SerializedName("green points")
    @Expose
    private String greenPoints;
    @SerializedName("blue points")
    @Expose
    private String bluePoints;
    @SerializedName("water_points")
    @Expose
    private String waterPoints;
    @SerializedName("yellow_points")
    @Expose
    private String yellowPoints;
    @SerializedName("purple_points")
    @Expose
    private String purplePoints;
    @SerializedName("brown_point")
    @Expose
    private String brownPoint;

    public String getGreenPoints() {
        return greenPoints;
    }

    public void setGreenPoints(String greenPoints) {
        this.greenPoints = greenPoints;
    }

    public String getBluePoints() {
        return bluePoints;
    }

    public void setBluePoints(String bluePoints) {
        this.bluePoints = bluePoints;
    }

    public String getWaterPoints() {
        return waterPoints;
    }

    public void setWaterPoints(String waterPoints) {
        this.waterPoints = waterPoints;
    }

    public String getYellowPoints() {
        return yellowPoints;
    }

    public void setYellowPoints(String yellowPoints) {
        this.yellowPoints = yellowPoints;
    }

    public String getPurplePoints() {
        return purplePoints;
    }

    public void setPurplePoints(String purplePoints) {
        this.purplePoints = purplePoints;
    }

    public String getBrownPoint() {
        return brownPoint;
    }

    public void setBrownPoint(String brownPoint) {
        this.brownPoint = brownPoint;
    }
}
