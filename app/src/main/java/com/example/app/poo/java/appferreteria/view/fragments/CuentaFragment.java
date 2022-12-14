package com.example.app.poo.java.appferreteria.view.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.poo.java.appferreteria.R;
import com.example.app.poo.java.appferreteria.databinding.ActivityLoginBinding;
import com.example.app.poo.java.appferreteria.databinding.FragmentCuentaBinding;
import com.example.app.poo.java.appferreteria.databinding.FragmentInicioBinding;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseLogin;
import com.example.app.poo.java.appferreteria.view.LoginActivity;
import com.example.app.poo.java.appferreteria.view.RegistrarUsuarioActivity;
import com.example.app.poo.java.appferreteria.viewmodel.LoginViewModel;
import com.example.app.poo.java.appferreteria.viewmodel.ProductoViewModel;

public class CuentaFragment extends Fragment {

    private FragmentCuentaBinding binding;
    private LoginViewModel loginViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCuentaBinding.inflate(inflater,container,false);


/*

        loginViewModel = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);
        binding = FragmentCuentaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnsalir.setOnClickListener((View.OnClickListener) this);
        loginViewModel= new ViewModelProvider(this)
                .get(LoginViewModel.class);
        loginViewModel.loginMutableLiveData.observe(getViewLifecycleOwner(),
                new Observer<ResponseLogin>() {
                    @Override
                    public void onChanged(ResponseLogin responseLogin) {
                        Salir(responseLogin);


                    }
                });*/


        return binding.getRoot();
    }


    private void setContentView(ConstraintLayout root) {
    }

    private void Salir(ResponseLogin responseLogin) {
    }




}