package com.example.assignment_md17301;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.assignment_md17301.Adapter.AdapterProduct;
import com.example.assignment_md17301.Constants.NetworkConstants;
import com.example.assignment_md17301.Interface.ApiService;
import com.example.assignment_md17301.Interface.ServerResponeProduct;
import com.example.assignment_md17301.model.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterProduct adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterProduct(new ArrayList<>());
        recyclerView.setAdapter(adapter);


        fetchItemsFromServer();
    }

    private void fetchItemsFromServer() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NetworkConstants.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<ServerResponeProduct> call = apiService.getProduct();
        call.enqueue(new Callback<ServerResponeProduct>() {
            @Override
            public void onResponse(Call<ServerResponeProduct> call, Response<ServerResponeProduct> response) {
                ServerResponeProduct resp = response.body();
                if (resp.getList()!= null){
                    Toast.makeText(MainActivity.this, "Không có gì", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Có da", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ServerResponeProduct> call, Throwable t) {

            }
        });

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menutoolbar, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.menu_add){
//            Intent intent = new Intent(MainActivity.this , LoginActivity.class);
//            startActivity(intent);
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}