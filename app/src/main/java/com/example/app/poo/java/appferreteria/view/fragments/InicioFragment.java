package com.example.app.poo.java.appferreteria.view.fragments;

import android.os.Bundle;

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

    private FragmentInicioBinding binding;
    private ProductoViewModel productoViewModel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInicioBinding.inflate(inflater,container,false);

        productoViewModel = new ViewModelProvider(requireActivity()).get(ProductoViewModel.class);

        binding.rvListaProductos.setLayoutManager(
                new LinearLayoutManager(requireActivity()));
        ProductoAdapter productoAdapter= new ProductoAdapter(requireActivity());
        binding.rvListaProductos.setAdapter(productoAdapter);
        productoViewModel.getProductos();
        productoViewModel.listProductosMutableLiveData.observe(getViewLifecycleOwner(),
                new Observer<List<ResponseProducto>>() {
                    @Override
                    public void onChanged(List<ResponseProducto> responseProductos) {
                        productoAdapter.setListaProductos(responseProductos);
                    }
                });

        return binding.getRoot();
    }
}

