package com.example.app.poo.java.appferreteria.view.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.poo.java.appferreteria.R;
import com.example.app.poo.java.appferreteria.databinding.ActivityMainBinding;
import com.example.app.poo.java.appferreteria.viewmodel.ProductoViewModel;

public class InicioFragment extends Fragment {

    private ActivityMainBinding binding;
    private ProductoViewModel productoViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}