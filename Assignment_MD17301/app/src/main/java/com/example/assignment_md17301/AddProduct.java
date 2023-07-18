package com.example.assignment_md17301;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment_md17301.Interface.ApiService;
import com.example.assignment_md17301.model.Product;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddProduct extends AppCompatActivity {

    private EditText etId, etName, etType, etCondition, etLifespan, etPrice, etDetail, etSeller;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        etId = findViewById(R.id.etId);
        etName = findViewById(R.id.edtName);
        etType = findViewById(R.id.etType);
        etCondition = findViewById(R.id.etCondition);
        etLifespan = findViewById(R.id.etLifespan);
        etPrice = findViewById(R.id.etPrice);
        etDetail = findViewById(R.id.etDetail);
        etSeller = findViewById(R.id.etSeller);

        btnAdd = findViewById(R.id.btnSubmit);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitData(view);
            }
        });

        onRestart();

    }

    public void submitData(View view) {
        // Get data from EditText fields
        String id = etId.getText().toString().trim();
        String name = etName.getText().toString().trim();
        String type = etType.getText().toString().trim();
        String condition = etCondition.getText().toString().trim();
        String lifespan = etLifespan.getText().toString().trim();
        Integer price = Integer.parseInt(etPrice.getText().toString().trim());
        String detail = etDetail.getText().toString().trim();
        String seller = etSeller.getText().toString().trim();

        // Create an Item object
        Product item = new Product(id, name, type, condition, lifespan, price, detail, seller);

        // Call the method to send data to the server
        sendDataToServer(item);
    }

    private void sendDataToServer(Product product) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.79:3000/api/") // Replace with your server URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<Product> call = apiService.addProduct(product);

        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if (response.isSuccessful()) {
                    // Data added successfully
                    Toast.makeText(AddProduct.this, "Data added successfully!", Toast.LENGTH_SHORT).show();
                    resetForm();
                } else {
                    // Handle API error
                    Toast.makeText(AddProduct.this, "Failed to add data to the server.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                // Handle network or other errors
                Toast.makeText(AddProduct.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void resetForm(){
        etId.setText("");
        etName.setText("");
        etType.setText("");
        etCondition.setText("");
        etLifespan.setText("");
        etDetail.setText("");
        etPrice.setText("");
        etSeller.setText("");

    }
}