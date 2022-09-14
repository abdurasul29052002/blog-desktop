package com.example.blogdesktop.singleton;

import com.google.gson.Gson;

public class MyGson {
    private static final MyGson myGson = new MyGson();
    private static Gson gson;


    public static MyGson getInstance(){
        if (gson==null){
            gson=new Gson();
        }
        return myGson;
    }

    public Gson getGson() {
        return gson;
    }

    private MyGson(){}
}
