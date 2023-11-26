package com.example.quickread.model;


import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;


import com.bumptech.glide.Glide;


import com.example.quickread.BR;
import com.example.quickread.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class NewsModel extends BaseObservable implements Parcelable {


    @SerializedName("urlToImage")
    @Expose
    private String urlToImage;


    @BindingAdapter({"urlToImage"})
    public static  void loadImage(ImageView imageView,String urlToImage){

        if(urlToImage!=null){
            Glide.with(imageView.getContext()).load(urlToImage).into(imageView);
        }else{
            Glide.with(imageView.getContext()).load(R.drawable.error).into(imageView);
        }

    }



    @SerializedName("source")
    @Expose
    private Source source;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;
    @SerializedName("content")
    @Expose
    private String content;


    @Bindable
    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Bindable
    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;

    }
@Bindable
    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int flags) {

        parcel.writeValue(title);
        parcel.writeValue(description);
        parcel.writeValue(publishedAt);
        parcel.writeValue(urlToImage);

    }

    public NewsModel() {
    }

    public NewsModel(Parcel parcel) {

        this.title = (String) parcel.readValue(String.class.getClassLoader());
        this.description = (String) parcel.readValue(String.class.getClassLoader());
        this.publishedAt = (String) parcel.readValue(String.class.getClassLoader());
        this.urlToImage = (String) parcel.readValue(String.class.getClassLoader());

    }


public  final static Parcelable.Creator<NewsModel> CREATOR = new Creator<NewsModel>() {
    @Override
    public NewsModel createFromParcel(Parcel source) {
        return new NewsModel(source);
    }

    @Override
    public NewsModel[] newArray(int size) {
        return new NewsModel[size];
    }
};



}
