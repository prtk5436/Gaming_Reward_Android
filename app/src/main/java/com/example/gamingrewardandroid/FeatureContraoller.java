package com.example.gamingrewardandroid;


import com.example.gamingrewardandroid.Dashboard.GameList;
import com.example.gamingrewardandroid.LoginStudent.StudentModel;
import com.example.gamingrewardandroid.LoginStudent.UserDetail;

import java.util.ArrayList;

public class FeatureContraoller {
    public static FeatureContraoller getFeatureContraoller() {
        return featureContraoller;
    }
    String userid;
String point;

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public static void setFeatureContraoller(FeatureContraoller featureContraoller) {
        FeatureContraoller.featureContraoller = featureContraoller;
    }

    String gamename[];

    public String[] getGamename() {
        return gamename;
    }

    public void setGamename(String[] gamename) {
        this.gamename = gamename;
    }

    public static FeatureContraoller featureContraoller ;
    //ArrayList<PackageInformation.InfoObject> gameList =new ArrayList<>();
    //PackageInformation.InfoObject selectedGame = new PackageInformation.InfoObject();
   public String memberId, schoolId, fullName, PRN;
    //public StudentModel studentModel;
    public  ArrayList<UserDetail> userDetails=new ArrayList<>();

    public ArrayList<UserDetail> getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(ArrayList<UserDetail> userDetails) {
        this.userDetails = userDetails;
    }

    public ArrayList<StudentModel> studentModel = new ArrayList<>();
    public  ArrayList<GameList> gamelist=new ArrayList<>();

    public ArrayList<GameList> getGamelist() {
        return gamelist;
    }

    public void setGamelist(ArrayList<GameList> gamelist) {
        this.gamelist = gamelist;
    }
//private List<Post> posts = new ArrayList<>();

    public static FeatureContraoller getInstance() {

        if(featureContraoller == null){
            featureContraoller = new FeatureContraoller();
        }
        return featureContraoller ;
    }

    public String getPRN() {
        return PRN;
    }

    public void setPRN(String PRN) {
        this.PRN = PRN;
    }

    public ArrayList<StudentModel> getStudentModel() {
        return studentModel;
    }

    public void setStudentModel(ArrayList<StudentModel> studentModel) {
        this.studentModel = studentModel;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

//    public List<Post> getPosts() {
   //     return posts;
    //}

  //  public void setPosts(List<Post> posts) {
    //    this.posts = posts;
    //}

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

  //  public ArrayList<PackageInformation.InfoObject> getGameList() {
      //  return gameList;
    //}

    //public void setGameList(ArrayList<PackageInformation.InfoObject> gameList) {
     //   this.gameList = gameList;
    //}

    //public PackageInformation.InfoObject getSelectedGame() {
     //   return selectedGame;
  //  }

    //public void setSelectedGame(PackageInformation.InfoObject selectedGame) {
     //   this.selectedGame = selectedGame;
    //}
}
