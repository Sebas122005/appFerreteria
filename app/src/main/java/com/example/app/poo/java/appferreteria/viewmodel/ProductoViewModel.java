package com.example.app.poo.java.appferreteria.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.app.poo.java.appferreteria.retrofit.response.ResponseProducto;
import com.example.app.poo.java.appferreteria.retrofit.services.Cliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductoViewModel extends AndroidViewModel {



    public MutableLiveData<List<ResponseProducto>> listProductosMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<List<ResponseProducto>> listCarrMutableLiveData = new MutableLiveData<>();

    public ProductoViewModel(@NonNull Application application) {
        super(application);
    }

    public void getProductos(){
        new Cliente().getINSTANCE().getProductos().enqueue(new Callback<List<ResponseProducto>>() {
            @Override
            public void onResponse(Call<List<ResponseProducto>> call, Response<List<ResponseProducto>> response) {
                Log.i("DATAREST",response.body().toString());
                listProductosMutableLiveData.setValue(response.body());
            }
            @Override
            public void onFailure(Call<List<ResponseProducto>> call, Throwable t) {
                Log.i("ERROR",t.getMessage().toString());
                t.printStackTrace();
            }
        });
    }

    public void cargarCarrrito(List<ResponseProducto> lista){
        listCarrMutableLiveData.setValue(lista);
    }

}
