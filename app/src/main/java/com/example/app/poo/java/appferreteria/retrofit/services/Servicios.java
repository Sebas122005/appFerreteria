package com.example.app.poo.java.appferreteria.retrofit.services;

import com.example.app.poo.java.appferreteria.retrofit.request.RequestLogin;
import com.example.app.poo.java.appferreteria.retrofit.request.RequestRegistro;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseCategoria;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseLogin;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseProducto;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseRegistro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface Servicios {

    @GET("producto/custom")
    public Call<List<ResponseProducto>> getProductos();

    @GET("categoria/custom")
    public Call<List<ResponseCategoria>> listarCategorias();

    @POST("cuenta/login")
    public Call<ResponseLogin> login(@Body RequestLogin requestLogin);

    @POST("persona/registrar")
    public Call<ResponseRegistro> registro(@Body RequestRegistro requestRegistro);


}
