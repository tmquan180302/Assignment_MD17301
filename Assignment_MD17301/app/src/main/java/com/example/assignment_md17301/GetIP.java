package com.example.assignment_md17301;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.assignment_md17301.model.ModelArray;

public class GetIP extends AppCompatActivity {
    WebView view;
    ModelArray modelArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_ip);

//        view = findViewById(R.id.idadd);
        WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.google.com");

        //Get IP
//        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
//        view.setText(Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress()));

        modelArray = new ModelArray();
    }
}