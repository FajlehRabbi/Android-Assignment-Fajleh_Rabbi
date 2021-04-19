package com.example.myapplication.Retrofit;


import com.example.myapplication.Model.BlogResource;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/api/unknown")
    Call<BlogResource> doGetListResources();
}

