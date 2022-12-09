package com.example.app.poo.java.appferreteria.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.app.poo.java.appferreteria.retrofit.request.RequestLogin;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseLogin;
import com.example.app.poo.java.appferreteria.retrofit.services.Cliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends AndroidViewModel {
    public MutableLiveData<ResponseLogin> loginMutableLiveData =
            new MutableLiveData<>();

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }
    public void autenticarUsuario(
            RequestLogin requestLogin){
        new Cliente().getINSTANCE().login(requestLogin)
                .enqueue(new Callback<ResponseLogin>() {
                    @Override
                    public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                        Log.i("DATALOGIN",response.body().toString());
                        loginMutableLiveData.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<ResponseLogin> call, Throwable t) {
                        t.printStackTrace();
                    }
                });

    }
}

