package com.example.assignment_md17301.Interface;

import com.example.assignment_md17301.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("getProduct")
    Call<List<Product>> getProduct();

    @POST("addProduct")
    Call<Product> addProduct(@Body Product product);


}
