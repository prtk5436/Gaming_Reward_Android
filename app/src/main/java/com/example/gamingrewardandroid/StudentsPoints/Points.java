package com.example.gamingrewardandroid.StudentsPoints;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Avik1 on 16/02/2016.
 */
public class Points {

    private int id=1;

    @SerializedName("green points")
    @Expose
    private int greenpoints = 0;
    @SerializedName("blue points")
    @Expose
    private int bluepoints = 0;
    @SerializedName("water_points")
    @Expose
    private int waterpoints = 0;
    @SerializedName("yellow_points")
    @Expose
    private int yellowpoints = 0;
    @SerializedName("purple_points")
    @Expose
    private int purplepoints = 0;
    @SerializedName("brown_point")
    @Expose
    private int brownpoints = 0;


    public Points(int id, int greenpoints, int yellowpoints,
                  int bluepoints, int waterpoints, int brownpoints, int purplepoints) {

        this.id=id;
        this.greenpoints=greenpoints;
        this.yellowpoints=yellowpoints;
        this.bluepoints=bluepoints;
        this.waterpoints=waterpoints;
        this.brownpoints=brownpoints;
        this.purplepoints=purplepoints;


    }

    public Points(int greenpoints, int yellowpoints,
                  int bluepoints, int waterpoints, int brownpoints, int purplepoints) {


        this.greenpoints=greenpoints;
        this.yellowpoints=yellowpoints;
        this.bluepoints=bluepoints;
        this.waterpoints=waterpoints;
        this.brownpoints=brownpoints;
        this.purplepoints=purplepoints;

    }
    public int getId() {
        return id;
    }

    public int getGreenpoints() {
        return greenpoints;
    }

    public int getYellowpoints() {
        return yellowpoints;
    }

    public int getBluepoints() {
        return bluepoints;
    }

    public int getWaterpoints() {
        return waterpoints;
    }

    public int getBrownpoints() {
        return brownpoints;
    }

    public int getPurplepoints() {
        return purplepoints;
    }
}
