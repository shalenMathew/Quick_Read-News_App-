package com.example.quickread.adpters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.PagerAdapter;

import com.example.quickread.model.NewsModel;
import com.example.quickread.NewsActivity;
import com.example.quickread.R;
import com.example.quickread.databinding.CustomItemBinding;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends PagerAdapter {


    private Context context;
    private List<NewsModel> newsList ;


    public CustomAdapter(Context context, List<NewsModel> newsList) {
        this.context = context;
        this.newsList = newsList;
    }



    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        CustomItemBinding customItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.custom_item,container,false);

  NewsModel newsModel = newsList.get(position);
  customItemBinding.setNews(newsModel);


customItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent i = new Intent(context, NewsActivity.class);
        i.putExtra("news",newsModel);
        context.startActivity(i);
    }
});


container.addView(customItemBinding.getRoot());



return customItemBinding.getRoot();
    }

    @Override
    public int getCount() {
            return newsList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
