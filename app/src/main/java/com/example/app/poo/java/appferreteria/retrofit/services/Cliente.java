package com.example.app.poo.java.appferreteria.retrofit.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Cliente {

    private static final String BASE_URL="http://192.168.137.1:8080/apiferreteria/";
    private Servicios INSTANCE;

    public Cliente(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        INSTANCE = retrofit.create(Servicios.class);
    }

    public Servicios getINSTANCE(){
        return INSTANCE;
    }

}