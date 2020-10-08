package com.example.gamingrewardandroid.SuggestGame;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SuggestGameInput {
    @SerializedName("operation")
    @Expose
    private String operation;
    @SerializedName("game_name")
    @Expose
    private String gameName;
    @SerializedName("game_parameter")
    @Expose
    private String gameParameter;
    @SerializedName("game_logo")
    @Expose
    private String gameLogo;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameParameter() {
        return gameParameter;
    }

    public void setGameParameter(String gameParameter) {
        this.gameParameter = gameParameter;
    }

    public String getGameLogo() {
        return gameLogo;
    }

    public void setGameLogo(String gameLogo) {
        this.gameLogo = gameLogo;
    }

}
