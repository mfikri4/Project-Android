package com.example.aplikasinajwashop.API;

import com.example.aplikasinajwashop.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRequestData {
    @GET("retrievedata.php")
    Call<ResponseModel> ardRetrieveData();

}
