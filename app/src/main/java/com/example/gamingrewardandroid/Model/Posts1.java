
package com.example.gamingrewardandroid.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Posts1 {

    @SerializedName("PlayerName")
    @Expose
    private String playerName;

    public String getPlayerName() {
        return playerName;
    }
}
