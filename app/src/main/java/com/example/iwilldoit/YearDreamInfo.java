package com.example.iwilldoit;

// 올해 버킷리스트 정보
public class YearDreamInfo {
    public String dream;
    public Boolean done;

    YearDreamInfo(){ }

    YearDreamInfo(String dream, Boolean done){
        this.dream = dream.trim();
        this.done = done;

    }
}
