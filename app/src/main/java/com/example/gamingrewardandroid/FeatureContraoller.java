package com.example.gamingrewardandroid;


import com.example.gamingrewardandroid.Dashboard.GameList;
import com.example.gamingrewardandroid.LoginStudent.StudentModel;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class FeatureContraoller {

   public static FeatureContraoller featureContraoller ;
    //ArrayList<PackageInformation.InfoObject> gameList =new ArrayList<>();
    //PackageInformation.InfoObject selectedGame = new PackageInformation.InfoObject();
   public String memberId, schoolId, fullName, PRN;
    //public StudentModel studentModel;
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
