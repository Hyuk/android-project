package com.example.network;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MyService {

    // https://api.github.com/
    @GET("users/{user}/repos")
    Call<JsonObject> getUseRepositories(@Path("user") String userName);

    @FormUrlEncoded
    @POST("users/repos")
    Call<JsonObject> postUser(@Field("username") String name, @Field("age") int age);
}
