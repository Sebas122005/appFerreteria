package com.example.app.poo.java.appferreteria.view.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.app.poo.java.appferreteria.Adapter.ProductoAdapter;
import com.example.app.poo.java.appferreteria.databinding.FragmentInicioBinding;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseProducto;
import com.example.app.poo.java.appferreteria.viewmodel.ProductoViewModel;
import java.util.List;

public class InicioFragment extends Fragment {

    FragmentInicioBinding binding;

    private ProductoViewModel productoViewModel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentInicioBinding.inflate(inflater,container,false);
        productoViewModel = new ViewModelProvider(this).get(ProductoViewModel.class);
        productoViewModel.getProductos();
        ProductoAdapter adapter = new ProductoAdapter();
        binding.rvListaProductos.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaProductos.setAdapter(adapter);
        productoViewModel.listProductosMutableLiveData.observe(getActivity(),
                new Observer<List<ResponseProducto>>() {
                    @Override
                    public void onChanged(List<ResponseProducto> responseProductos) {
                        adapter.setListaProductos(responseProductos);
                    }
                });


        return binding.getRoot();

    }
}

