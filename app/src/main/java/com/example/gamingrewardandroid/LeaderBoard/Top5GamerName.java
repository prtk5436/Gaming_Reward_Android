package com.example.gamingrewardandroid.LeaderBoard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Top5GamerName {
    @SerializedName("Gamer_name")
    @Expose
    private String gamerName;
    @SerializedName("Points")
    @Expose
    private String points;

    public String getGamerName() {
        return gamerName;
    }

    public void setGamerName(String gamerName) {
        this.gamerName = gamerName;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

}
