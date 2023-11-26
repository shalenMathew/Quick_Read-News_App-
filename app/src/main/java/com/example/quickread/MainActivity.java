package com.example.quickread;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.quickread.model.NewsModel;
import com.example.quickread.SlideAnimation.ZoomSwipeAnimation;
import com.example.quickread.ViewModel.ViewModel;
import com.example.quickread.adpters.CustomAdapter;
import com.example.quickread.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FetchDataListener{

    //    https://newsapi.org/v2/top-headlines?country=in&apiKey=cbb4917d2c5e4f4abf80141744e160f1

    ActivityMainBinding activityMainBinding;
    private ViewPager viewPager;
    CustomAdapter customAdapter;
    ViewModel activityViewModel;
   private ArrayList<NewsModel> newsList;

   ProgressDialog dialog;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(this);
        dialog.setTitle("Fetching news ....");
        dialog.show();



        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        activityViewModel = new ViewModelProvider(this).get(ViewModel.class);

        activityViewModel.getAllNews(this);




    }

//    private void getNews() {
//
////        activityViewModel.getAllNews().observe(this, new Observer<List<NewsModel>>() {
////            @Override
////            public void onChanged(List<NewsModel> newsModels) {
////
////                list = (ArrayList<NewsModel>) newsModels;
////                showOnViewPager();
////            }
////        });
//
//
//
//
//    }



    @Override
    public void FetchData(List list, String message) {

       newsList=(ArrayList<NewsModel>) list;
        showOnViewPager();
        dialog.dismiss();

    }

    @Override
    public void OnError(String message) {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }



    private void showOnViewPager() {

        viewPager=activityMainBinding.viewPager;
        customAdapter = new CustomAdapter(this, newsList);
        viewPager.setPageTransformer(true, new ZoomSwipeAnimation());
        viewPager.setAdapter(customAdapter);

    }
}