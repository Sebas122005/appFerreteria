package com.example.app.poo.java.appferreteria.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.app.poo.java.appferreteria.retrofit.response.ResponseCategoria;
import com.example.app.poo.java.appferreteria.retrofit.services.Cliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriaViewModel extends AndroidViewModel {

    public MutableLiveData<List<ResponseCategoria>> listCategoriaMutableLiveData = new MutableLiveData<>();

    public CategoriaViewModel(@NonNull Application application) {
        super(application);
    }

    public void listarCategorias(){
        new Cliente().getINSTANCE().listarCategorias().enqueue(new Callback<List<ResponseCategoria>>() {
            @Override
            public void onResponse(Call<List<ResponseCategoria>> call, Response<List<ResponseCategoria>> response) {
                Log.i("DATACATEGORIA",response.body().toString());
                listCategoriaMutableLiveData.setValue(response.body());
            }
            @Override
            public void onFailure(Call<List<ResponseCategoria>> call, Throwable t) {
                Log.i("ERRORCATEGORIA",t.getMessage().toString());
                t.printStackTrace();
            }
        });
    }

}
