package com.example.app.poo.java.appferreteria.retrofit.services;

import com.example.app.poo.java.appferreteria.retrofit.response.ResponseProducto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Servicios {


    @GET("producto/custom")
    public Call<List<ResponseProducto>> getProductos();

}
