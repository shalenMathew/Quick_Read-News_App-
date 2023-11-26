package com.example.quickread.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.quickread.FetchDataListener;
import com.example.quickread.R;
import com.example.quickread.service.NewsApiGetService;
import com.example.quickread.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {


Application application;

ArrayList<NewsModel> newsList = new ArrayList<>();

MutableLiveData<List<NewsModel>> mutableLiveData = new MutableLiveData<>();


    public NewsRepository(Application application) {
        this.application = application;
    }




    public  MutableLiveData<List<NewsModel>> getMutableLiveData(){

        NewsApiGetService newsApiGetService = RetrofitInstance.getService();

        Call<Result> call = newsApiGetService.getNews("in",application.getApplicationContext().getString(R.string.api_key));

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                Result result = response.body();

                if(result!=null && result.getTotalResults()!=null){

                    newsList = (ArrayList<NewsModel>) result.getResults();
                }

                mutableLiveData.setValue(newsList);

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                

            }
        });

        return  mutableLiveData;
    }




//    public void fetchData(FetchDataListener listener){
//
//        NewsApiGetService newsApiGetService = RetrofitInstance.getService();
//
//        Call<Result> call = newsApiGetService.getNews("in",application.getApplicationContext().getString(R.string.api_key));
//
//call.enqueue(new Callback<Result>() {
//    @Override
//    public void onResponse(Call<Result> call, Response<Result> response) {
//
//        Result result = response.body();
//
//        if(result!=null && result.getTotalResults()!=null){
//
//            newsList = (ArrayList<NewsModel>) result.getResults();
//        }
//
//        mutableLiveData.setValue(newsList);
//        listener.FetchData(newsList,response.message());
//
//
//    }
//
//    @Override
//    public void onFailure(Call<Result> call, Throwable t) {
//
//        listener.OnError("Request failed");
//
//    }
//});
//
//    }
//
//
//
//
//    public  MutableLiveData<List<NewsModel>> getMutableLiveData(){
//        return  mutableLiveData;
//    }
}
