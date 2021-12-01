package com.example.iwilldoit;

public class LifeDreamInfo {

    public String dream;
    public Boolean done;

    LifeDreamInfo(){ }

    LifeDreamInfo(String dream, Boolean done){
        this.dream = dream.trim();
        this.done = done;
    }
}
