package com.example.assignment_md17301;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment_md17301.Constants.NetworkConstants;
import com.example.assignment_md17301.Interface.ApiService;
import com.example.assignment_md17301.Interface.ServerReqLogin;
import com.example.assignment_md17301.Interface.ServerRespone;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout textInputLayoutEmail, textInputLayoutPassword;

    TextView txtRegistered;

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        txtRegistered = findViewById(R.id.txtRegister);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = textInputLayoutEmail.getEditText().getText().toString().trim();
                String password = textInputLayoutPassword.getEditText().getText().toString().trim();
                try {
                    submit(email,password);

                }catch (Exception e){
                    Toast.makeText(LoginActivity.this, "That bai", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txtRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }

        });
    }

    private void submit(String email, String password) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        ServerReqLogin serverReqLogin = new ServerReqLogin();
        serverReqLogin.setOperation("login");
        serverReqLogin.setEmail(email);
        serverReqLogin.setPassword(password);

        Call<ServerRespone> call = apiService.login(serverReqLogin);

        call.enqueue(new Callback<ServerRespone>() {
            @Override
            public void onResponse(Call<ServerRespone> call, Response<ServerRespone> response) {
                ServerRespone resp = response.body();
                if (resp.getResult().equals("success")){
                    Toast.makeText(getApplicationContext(), ""+resp.getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                if (resp.getResult().equals("failed")){
                    Toast.makeText(getApplicationContext(), ""+resp.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ServerRespone> call, Throwable t) {

            }
        });



    }
}