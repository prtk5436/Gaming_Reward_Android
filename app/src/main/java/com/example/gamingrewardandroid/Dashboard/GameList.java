package com.example.gamingrewardandroid.Dashboard;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GameList {
    @SerializedName("game_id")
    @Expose
    private String gameId;
    @SerializedName("game_name")
    @Expose
    private String gameName;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}
