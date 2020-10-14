package com.example.gamingrewardandroid;


import com.example.gamingrewardandroid.Dashboard.GameListInput;
import com.example.gamingrewardandroid.Dashboard.GameListOutput;
import com.example.gamingrewardandroid.GamerProfile.ProfileInPut;
import com.example.gamingrewardandroid.GamerProfile.ProfileShowOutPut;
import com.example.gamingrewardandroid.GamerProfile.UpdateProfileInput;
import com.example.gamingrewardandroid.GamerProfile.UpdateProfileOutput;
import com.example.gamingrewardandroid.LoginStudent.LoginInput;
import com.example.gamingrewardandroid.LoginStudent.LoginOutput;
import com.example.gamingrewardandroid.PointsForm.AssignPointsInput;
import com.example.gamingrewardandroid.PointsForm.AssignPointsOutput;
import com.example.gamingrewardandroid.PointsForm.ReawardParameterOutput;
import com.example.gamingrewardandroid.PointsForm.RewardParameterInput;
import com.example.gamingrewardandroid.Registration.StudentRegistraionOutput;
import com.example.gamingrewardandroid.Registration.StudentRegistrationInput;
import com.example.gamingrewardandroid.StudentsPoints.InputPoints;
import com.example.gamingrewardandroid.StudentsPoints.OutputPoints;
import com.example.gamingrewardandroid.SuggestGame.SuggestGameInput;
import com.example.gamingrewardandroid.SuggestGame.SuggestGameOutput;
import com.example.gamingrewardandroid.WebServiceClasses.WebserviceConstant;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthenticationApi {

    @POST ("core/webservice_game.php")
    Call<OutputPoints> getStudentPoints(@Body InputPoints d);
    //updateprofile
    @POST ("core/webservice_game.php")
    Call<UpdateProfileOutput> updateProfile(@Body UpdateProfileInput d);
    @POST ("core/webservice_game.php")
    Call<ProfileShowOutPut> showprofile(@Body ProfileInPut d);
    @POST ("core/webservice_game.php")
    Call<LoginOutput> getlogin(@Body LoginInput i);
    @POST(WebserviceConstant.GAME_API)
    Call<GameListOutput> getgamelist(@Body GameListInput g);


    @POST("core/webservice_game.php")
    Call<StudentRegistraionOutput> getRegisterResponse(@Body StudentRegistrationInput r);
    @POST("core/webservice_game.php")
    Call<AssignPointsOutput> getSelfReward(@Body AssignPointsInput r);

    @POST(WebserviceConstant.GAME_API)
    Call<ReawardParameterOutput> getGameParameterList(@Body RewardParameterInput g);
    @POST(WebserviceConstant.GAME_API)
    Call<SuggestGameOutput> suggestGame(@Body SuggestGameInput g);


}
