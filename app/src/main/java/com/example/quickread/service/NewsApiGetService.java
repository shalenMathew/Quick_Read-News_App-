package com.example.quickread.service;

import com.example.quickread.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApiGetService {


    @GET("top-headlines")
    Call<Result> getNews(@Query("country") String country, @Query("apiKey") String api_key);


}
