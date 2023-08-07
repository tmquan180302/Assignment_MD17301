package com.example.assignment_md17301.Interface;

import com.example.assignment_md17301.Constants.NetworkConstants;
import com.example.assignment_md17301.model.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

//    Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
//    ApiService apiService = new Retrofit.Builder()
//            .baseUrl(NetworkConstants.URL) // Replace with your MongoDB API URL
//            .addConverterFactory(GsonConverterFactory.create(gson)) // help transform Java object to JSON
//            .build()
//            .create(ApiService.class);

    @POST("addUser/")
    Call<ServerRespone> operation (@Body ServerRequest request);

    //    Call<ServerRespone> login(@Body ServerRequest request);
    @POST("login/")
    Call<ServerRespone> login(@Body ServerReqLogin reqLogin);


    @GET("getProduct/")
    Call<ServerResponeProduct> getProduct();

    @POST("addProduct/")
    Call<Product> addProduct(@Body Product product);


}
