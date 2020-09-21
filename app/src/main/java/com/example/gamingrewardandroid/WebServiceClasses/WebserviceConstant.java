package com.example.gamingrewardandroid.WebServiceClasses;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.gamingrewardandroid.MainApplication;


public class WebserviceConstant {
    public static final String GAME_API="core/webservice_game.php";

    public static final String HTTP_BASE_URL1 = "https://";
    //public static final String BASE_URL = "https://test.smartcookie.in/";
    public static String BASE_URL = "https://smartcookie.in/";
     //public static final String BASE_URL = "https://smartcookie.in/";
     public static String BASE_URL1 = "smartcookie.in/core/";

   //public static String BASE_URL = "http://192.168.1.161/";
   public static final String STUDENT_LOGIN_V3 = "core/Version3/login_student_V4.php";
    public static final String SPECTATOR_LOGIN = "core/Version4/spectator_volunteer_login_ws_V2.php";
    public static final String SPECTATOR_REGISTRATION = "core/Version4/SpectatorRegistrationAPI_V2.php";
    public static final String STUDENT_REGISTRATION = "core/Version4/quickregistration_ws_v1.php";
    public static final String GET_PLAYER_LIST = "core/Version4/Player_list_API.php";
    public static final String DISPLAY_SPECTATOR_POINTS = "core/Version4/display_spectator_points.php";
    public static final String ASSIGN_POINTS_TO_PLAYER = "core/Version4/AssignPointsToPlayerAPI.php";

    public static final String GENERATE_COUPON = "core/Version4/generateCouponAPI.php";
    public static final String GENERATE_COUPON_LIST = "core/Version4/display_spectator_couponlist_ws.php";
    public static final String USED_COUPON_LOG = "core/Version4/display_spectator_couponlist_ws.php";
  //  public static final String Blogs= "new/wp-json/wp/v2/posts?per_page=2&fields=id,title,image,content,modified,college_name";
    //public static final String AddBlogs= "https://smartcookie.in/new/wp-json/wp/v2/posts?";
    //public static final String AddBlogs= "http://192.168.1.161/new/wp-json/wp/v2/posts";
   // public static final String AddBlogs= "new/wp-json/wp/v2/posts";

    public static final String SOFT_REWARD_LIST = "core/Version3/softrewardslist_API.php";
    public static final String SOFT_REWARD_LOG= "core/Version3/Get_user_softrewards_API.php";
    public static final String PURCHASE_SOFT_REWARD = "core/Version4/purchase_soft_reward_spectator_API.php";

    public static final String GAMING_POINT = "core/webservice_game.php";
    public static final String STUDENT_POINTS = "core/Version4/display_student_allpoints.php";

    //public static final String GAMING_REWARD_LOG = "";

    public static final int CAMERA_PERMISSION_CODE = 11;
    public static final String APPTYPE = "APPTYPE";
    public static final String TEST = "TEST";
    public static final String PRODUCTION = "PRODUCTION";
    public static final String DEVELOPMENT="DEVELOPMENT";
    //public static final String SchooId="KI2019";

    public static final String SchooId = "TECHNEX19";
    public static final String DISPLAY_BLOGS1= "Version4/DisplayBlog_API.php";


   // ---------------------------------------------------------------------------------

    public static final String DISPLAY_BLOGS= "core/Version4/DisplayBlog_API.php";
    public static final String ADD_BLOG= "core/Version4/AddBlog_API.php";













 /*   static Context context = MainApplication.getContext();
   static SharedPreferences pref = context.getSharedPreferences("user_details",context.MODE_PRIVATE);

    static {
        if (pref.getString("apptype","").equals(WebserviceConstant.TEST)) {
            BASE_URL ="https://test.smartcookie.in/";
           // BASE_URL = "https://smartcookie.in/";

        } else if (pref.getString("apptype","").equals(WebserviceConstant.PRODUCTION)) {
            BASE_URL = "https://smartcookie.in/";

        }else if (pref.getString("apptype","").equals(WebserviceConstant.DEVELOPMENT)) {
            BASE_URL = "https://dev.smartcookie.in/";
          //  BASE_URL = "https://smartcookie.in/";
        }
    }

  */

    public static void setAppType(String Apptype) {
        if (Apptype.equals(WebserviceConstant.TEST)) {

            BASE_URL ="https://test.smartcookie.in/";
            //BASE_URL = "https://smartcookie.in/";
        } else if (Apptype.equals(WebserviceConstant.PRODUCTION)){

            BASE_URL = "https://smartcookie.in/";         // http://www.smartcookie.in/core/Version2/social_login_webservice.php

        } else if (Apptype.equals(WebserviceConstant.DEVELOPMENT)){

            BASE_URL = "https://dev.smartcookie.in/";         // http://www.smartcookie.in/core/Version2/social_login_webservice.php
            //BASE_URL = "https://smartcookie.in/";
        }
    }



}
