package com.example.gamingrewardandroid;

public class MyFeatureController {

    String MemberID ="";

    public static FeatureContraoller featureContraoller ;

    public static FeatureContraoller getInstance() {

        if(featureContraoller == null){
            featureContraoller = new FeatureContraoller();
        }
        return featureContraoller ;
    }

    public String getMemberID() {
        return MemberID;
    }

    public void setMemberID(String memberID) {
        MemberID = memberID;
    }
}
