package com.example.app.poo.java.appferreteria.retrofit.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductoCliente {

    private static final String BASE_URL="http://localhost:8590/apiferreteria/";
    private static Servicios INSTANCE;

    public ProductoCliente(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        INSTANCE = retrofit.create(Servicios.class);

    }

    public static Servicios getINSTANCE(){
        return INSTANCE;
    }



}
