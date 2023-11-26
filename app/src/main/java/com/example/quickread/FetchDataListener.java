package com.example.quickread;

import com.example.quickread.model.NewsModel;

import java.util.List;

public interface FetchDataListener<Result>{

    void FetchData(List<NewsModel> list,String message);

    void OnError(String message);



}
