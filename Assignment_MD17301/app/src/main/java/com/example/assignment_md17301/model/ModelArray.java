package com.example.assignment_md17301.model;

public class ModelArray {
    String[] name ;
    int[] age;

    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public int[] getAge() {
        return age;
    }

    public void setAge(int[] age) {
        this.age = age;
    }

    public ModelArray(String[] name, int[] age) {
        this.name = name;
        this.age = age;
    }
}
