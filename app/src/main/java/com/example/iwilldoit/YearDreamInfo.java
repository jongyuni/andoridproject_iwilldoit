package com.example.iwilldoit;

public class YearDreamInfo {
    public String dream;
    public Boolean done;

    YearDreamInfo(){ }

    YearDreamInfo(String dream, Boolean done){
        this.dream = dream.trim();
        this.done = done;

    }
}
