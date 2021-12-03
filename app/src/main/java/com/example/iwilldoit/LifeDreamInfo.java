package com.example.iwilldoit;

// 인생 버킷리스트 정보
public class LifeDreamInfo {

    public String dream;
    public Boolean done;

    LifeDreamInfo(){ }

    LifeDreamInfo(String dream, Boolean done){
        this.dream = dream.trim();
        this.done = done;
    }
}
