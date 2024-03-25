package com.example.assignment_md17301.Interface;

import com.example.assignment_md17301.model.Product;

import retrofit2.Call;
import retrofit2.http.Body;
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
    Call<ServerResponseProduct> getProduct();

    @POST("addProduct/")
    Call<Product> addProduct(@Body Product product);




}
