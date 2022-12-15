package com.example.app.poo.java.appferreteria.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.app.poo.java.appferreteria.Adapter.CategoriaAdapter;
import com.example.app.poo.java.appferreteria.databinding.FragmentCategoriaBinding;
import com.example.app.poo.java.appferreteria.databinding.FragmentCuentaBinding;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseCategoria;
import com.example.app.poo.java.appferreteria.R;
import com.example.app.poo.java.appferreteria.view.LoginActivity;
import com.example.app.poo.java.appferreteria.viewmodel.CategoriaViewModel;

import java.util.List;

public class CuentaFragment extends Fragment {
    private FragmentCuentaBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCuentaBinding.inflate(inflater,container,false);
        //binding.imgcuenta.setImageResource(R.drawable.img_user);
        binding.btnsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return binding.getRoot();
    }
}