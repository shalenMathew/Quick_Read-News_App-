package com.example.quickread.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Result implements Parcelable {


    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;
    @SerializedName("articles")
    @Expose
    private List<NewsModel> results=null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<NewsModel> getResults() {
        return results;
    }

    public void setResults(List<NewsModel> results) {
        this.results = results;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int flags) {

parcel.writeValue(results);
parcel.writeValue(status);
parcel.writeValue(totalResults);


    }

    public Result() {

    }

    public Result(Parcel parcel) {

        this.status = (String) parcel.readValue(String.class.getClassLoader());
        this.totalResults=(Integer) parcel.readValue(Integer.class.getClassLoader());
        parcel.readList(this.results,(com.example.quickread.model.NewsModel.class.getClassLoader()));

    }


    public final static Parcelable.Creator<Result>  CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel parcel) {
            return new Result(parcel);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };
}
