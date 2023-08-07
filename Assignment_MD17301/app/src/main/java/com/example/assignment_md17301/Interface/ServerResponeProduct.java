package com.example.assignment_md17301.Interface;

import com.example.assignment_md17301.model.Product;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ServerResponeProduct {

    private String result , message;

    @SerializedName("list")
    private List<Product> list ;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }
}
