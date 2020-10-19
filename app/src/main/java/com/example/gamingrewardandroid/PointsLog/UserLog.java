package com.example.gamingrewardandroid.PointsLog;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserLog {
    @SerializedName("game_id")
    @Expose
    private String gameId;
    @SerializedName("game_name")
    @Expose
    private String gameName;
    @SerializedName("school_id")
    @Expose
    private String schoolId;
    @SerializedName("sc_member_id")
    @Expose
    private String scMemberId;
    @SerializedName("member_type")
    @Expose
    private String memberType;
    @SerializedName("gain_points")
    @Expose
    private String gainPoints;

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

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getScMemberId() {
        return scMemberId;
    }

    public void setScMemberId(String scMemberId) {
        this.scMemberId = scMemberId;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getGainPoints() {
        return gainPoints;
    }

    public void setGainPoints(String gainPoints) {
        this.gainPoints = gainPoints;
    }
}
