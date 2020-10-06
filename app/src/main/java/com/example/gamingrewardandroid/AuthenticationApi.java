package com.example.gamingrewardandroid;


import com.example.gamingrewardandroid.Dashboard.GameListInput;
import com.example.gamingrewardandroid.Dashboard.GameListOutput;
import com.example.gamingrewardandroid.LoginStudent.LoginStudentInput;
import com.example.gamingrewardandroid.LoginStudent.LoginStudentOutput;
import com.example.gamingrewardandroid.Registration.StudentRegistraionOutput;
import com.example.gamingrewardandroid.Registration.StudentRegistrationInput;
import com.example.gamingrewardandroid.StudentsPoints.InputPoints;
import com.example.gamingrewardandroid.StudentsPoints.OutputPoints;
import com.example.gamingrewardandroid.WebServiceClasses.WebserviceConstant;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthenticationApi {

   // @Headers("Content-Type: application/json")
  //  @POST(WebserviceConstant.SPECTATOR_LOGIN)
   // Call<LoginResponse> getLoginResponse(@Body InputParameterResponse response);

    @POST(WebserviceConstant.STUDENT_LOGIN_V3)
    Call<LoginStudentOutput> getLoginResponse(@Body LoginStudentInput response);
    @POST(WebserviceConstant.STUDENT_POINTS)
    Call<OutputPoints> getStudentPoints(@Body InputPoints d);

    @POST(WebserviceConstant.GAME_API)
    Call<GameListOutput> getgamelist(@Body GameListInput g);


    @POST(WebserviceConstant.STUDENT_REGISTRATION)
    Call<StudentRegistraionOutput> getRegisterResponse(@Body StudentRegistrationInput r);



}
