package com.example.quickread.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.quickread.model.NewsModel;
import com.example.quickread.model.NewsRepository;
import com.example.quickread.model.Result;
import  com.example.quickread.FetchDataListener;

import java.util.List;

public class ViewModel extends AndroidViewModel {


   private NewsRepository newsRepository;


    public ViewModel(@NonNull Application application) {
        super(application);
        this.newsRepository = new NewsRepository(application);
    }





public  void getAllNews(FetchDataListener listener){

   newsRepository.getMutableLiveData().observeForever(new Observer<List<NewsModel>>() {
       @Override
       public void onChanged(List<NewsModel> list) {
           listener.FetchData(list,"success");
       }
   });

}



}
