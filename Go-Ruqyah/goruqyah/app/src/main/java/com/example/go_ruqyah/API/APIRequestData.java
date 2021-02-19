package com.example.go_ruqyah.API;

import com.example.go_ruqyah.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRequestData {
    @GET("retrievedata.php")
    Call<ResponseModel> ardRetrieveData();

}
