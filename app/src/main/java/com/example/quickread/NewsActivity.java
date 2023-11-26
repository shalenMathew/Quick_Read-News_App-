package com.example.quickread;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.quickread.databinding.ActivityNewsBinding;
import com.example.quickread.model.NewsModel;

public class NewsActivity extends AppCompatActivity {

    ActivityNewsBinding activityNewsBinding;

    NewsModel newsModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);


        activityNewsBinding = DataBindingUtil.setContentView(this,R.layout.activity_news);

        Intent i = getIntent();

        if(i!=null){
            newsModel = i.getParcelableExtra("news");
            activityNewsBinding.setNews(newsModel);
        }


    }
}