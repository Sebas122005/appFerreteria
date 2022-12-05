package com.example.app.poo.java.appferreteria.viewmodel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.app.poo.java.appferreteria.retrofit.response.ResponseProducto;
import com.example.app.poo.java.appferreteria.retrofit.services.ProductoCliente;
import com.example.app.poo.java.appferreteria.view.MainActivity;
import com.example.app.poo.java.appferreteria.view.fragments.InicioFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductoViewModel extends AndroidViewModel {

    public ProductoViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<ResponseProducto>> listProductosMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String> productos = new MutableLiveData<>();


    public void getProductos(){
        ProductoCliente.getINSTANCE().getProductos().enqueue(new Callback<List<ResponseProducto>>() {
            @Override
            public void onResponse(Call<List<ResponseProducto>> call, Response<List<ResponseProducto>> response) {
                listProductosMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ResponseProducto>> call, Throwable t) {
                t.printStackTrace();
                productos.setValue(t.getMessage());
            }
        });
    }

}
