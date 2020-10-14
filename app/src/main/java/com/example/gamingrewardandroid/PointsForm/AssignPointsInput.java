package com.example.gamingrewardandroid.PointsForm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AssignPointsInput {
    @SerializedName("operation")
    @Expose
    private String operation;
    @SerializedName("SC_Member_ID")
    @Expose
    private String sCMemberID;
    @SerializedName("School_id")
    @Expose
    private String schoolId;
    @SerializedName("mobile_no")
    @Expose
    private String mobileNo;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("game_id")
    @Expose
    private String gameId;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("Kills")
    @Expose
    private String kills;
    @SerializedName("Rank")
    @Expose
    private String rank;
    @SerializedName("WIN_or_not")
    @Expose
    private String wINOrNot;
    @SerializedName("Level")
    @Expose
    private String level;
    @SerializedName("Stars")
    @Expose
    private String stars;
    @SerializedName("Trophies")
    @Expose
    private String trophies;
    @SerializedName("Total_coins_earned")
    @Expose
    private String totalCoinsEarned;
    @SerializedName("Winner_on_1st_rank")
    @Expose
    private String winnerOn1stRank;
    @SerializedName("Distance")
    @Expose
    private String distance;
    @SerializedName("Coins_earned")
    @Expose
    private String coinsEarned;
    @SerializedName("moves")
    @Expose
    private String moves;
    @SerializedName("Score")
    @Expose
    private String score;
    @SerializedName("Money_won")
    @Expose
    private String moneyWon;
    @SerializedName("Rank_in_competition")
    @Expose
    private String rankInCompetition;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getSCMemberID() {
        return sCMemberID;
    }

    public void setSCMemberID(String sCMemberID) {
        this.sCMemberID = sCMemberID;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getKills() {
        return kills;
    }

    public void setKills(String kills) {
        this.kills = kills;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getWINOrNot() {
        return wINOrNot;
    }

    public void setWINOrNot(String wINOrNot) {
        this.wINOrNot = wINOrNot;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getTrophies() {
        return trophies;
    }

    public void setTrophies(String trophies) {
        this.trophies = trophies;
    }

    public String getTotalCoinsEarned() {
        return totalCoinsEarned;
    }

    public void setTotalCoinsEarned(String totalCoinsEarned) {
        this.totalCoinsEarned = totalCoinsEarned;
    }

    public String getWinnerOn1stRank() {
        return winnerOn1stRank;
    }

    public void setWinnerOn1stRank(String winnerOn1stRank) {
        this.winnerOn1stRank = winnerOn1stRank;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getCoinsEarned() {
        return coinsEarned;
    }

    public void setCoinsEarned(String coinsEarned) {
        this.coinsEarned = coinsEarned;
    }

    public String getMoves() {
        return moves;
    }

    public void setMoves(String moves) {
        this.moves = moves;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getMoneyWon() {
        return moneyWon;
    }

    public void setMoneyWon(String moneyWon) {
        this.moneyWon = moneyWon;
    }

    public String getRankInCompetition() {
        return rankInCompetition;
    }

    public void setRankInCompetition(String rankInCompetition) {
        this.rankInCompetition = rankInCompetition;
    }

}
