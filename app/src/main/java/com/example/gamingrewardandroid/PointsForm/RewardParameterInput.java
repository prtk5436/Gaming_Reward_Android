package com.example.gamingrewardandroid.PointsForm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RewardParameterInput {
    @SerializedName("operation")
    @Expose
    private String operation;
    @SerializedName("game_id")
    @Expose
    private String gameId;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}
