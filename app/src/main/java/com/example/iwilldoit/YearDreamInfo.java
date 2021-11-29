package com.example.iwilldoit;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class YearDreamInfo {
    public String dream;
    public Boolean done;
    YearDreamInfo(){

    }

    YearDreamInfo(String dream, String done){
        this.dream = dream.trim();
        if (done.trim().equals("True")){
            this.done = TRUE;
        }
        else{
            this.done = FALSE;
        }

    }
}
