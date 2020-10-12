package com.example.gamingrewardandroid.PointsForm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AssignPointsInput {
    @SerializedName("operation")
    @Expose
    private String operation;
    @SerializedName("Member_type")
    @Expose
    private String memberType;
    @SerializedName("School_id")
    @Expose
    private String schoolId;
    @SerializedName("mobile_no")
    @Expose
    private String mobileNo;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("game_id")
    @Expose
    private String gameId;
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
    private String star;
    @SerializedName("Trophies")
    @Expose
    private String trophies;
    @SerializedName("Total_coins_earned")
    @Expose
    private String coinsgain;
    @SerializedName("Winner_on_1st_rank")
    @Expose
    private String winner_on_1st;
    @SerializedName("Distance")
    @Expose
    private String distance;
    @SerializedName("Coins_earned")
    @Expose
    private String coins_earned;
    @SerializedName("distance")
    @Expose
    private String Distance;
    @SerializedName("Level")
    @Expose
    private String Level;
    @SerializedName("moves")
    @Expose
    private String moves;
    @SerializedName("Score")
    @Expose
    private String score;
    @SerializedName("Money_won")
    @Expose
    private String money_won;
    @SerializedName("Rank_in_competition")
    @Expose
    private String competitionrank;

    public String getCompetitionrank() {
        return competitionrank;
    }

    public void setCompetitionrank(String competitionrank) {
        this.competitionrank = competitionrank;
    }

    public String getwINOrNot() {
        return wINOrNot;
    }

    public void setwINOrNot(String wINOrNot) {
        this.wINOrNot = wINOrNot;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public String getMoney_won() {
        return money_won;
    }

    public void setMoney_won(String money_won) {
        this.money_won = money_won;
    }

    public String getRankincompetition() {
        return Rankincompetition;
    }

    public void setRankincompetition(String rankincompetition) {
        Rankincompetition = rankincompetition;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getTrophies() {
        return trophies;
    }

    public void setTrophies(String trophies) {
        this.trophies = trophies;
    }

    public String getCoinsgain() {
        return coinsgain;
    }

    public void setCoinsgain(String coinsgain) {
        this.coinsgain = coinsgain;
    }

    public String getWinner_on_1st() {
        return winner_on_1st;
    }

    public void setWinner_on_1st(String winner_on_1st) {
        this.winner_on_1st = winner_on_1st;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getCoins_earned() {
        return coins_earned;
    }

    public void setCoins_earned(String coins_earned) {
        this.coins_earned = coins_earned;
    }

    @SerializedName("Rank_in_competition")
    @Expose
    private String Rankincompetition;








    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
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

}
