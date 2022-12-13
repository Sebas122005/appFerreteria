package com.example.app.poo.java.appferreteria.view.fragments;

import android.content.Context;
import android.content.Intent;
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
import com.example.app.poo.java.appferreteria.view.CarritoActivity;
import com.example.app.poo.java.appferreteria.view.MainActivity;
import com.example.app.poo.java.appferreteria.viewmodel.ProductoViewModel;

import java.util.ArrayList;
import java.util.List;

public class InicioFragment extends Fragment {

    private FragmentInicioBinding binding;
    private ProductoViewModel productoViewModel;
    List<ResponseProducto> lista;
    Context context;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInicioBinding.inflate(inflater,container,false);

        productoViewModel = new ViewModelProvider(requireActivity()).get(ProductoViewModel.class);

        binding.rvListaProductos.setLayoutManager(
                new LinearLayoutManager(requireActivity()));
        ProductoAdapter productoAdapter= new ProductoAdapter(requireActivity(),lista);
        binding.rvListaProductos.setAdapter(productoAdapter);
        productoViewModel.getProductos();
        productoViewModel.listProductosMutableLiveData.observe(getViewLifecycleOwner(),
                new Observer<List<ResponseProducto>>() {
                    @Override
                    public void onChanged(List<ResponseProducto> responseProductos) {
                        productoAdapter.setListaProductos(responseProductos);
                    }
                });
        binding.btnIrCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lista = productoAdapter.setListaCarrito();
                Intent intent = new Intent(requireActivity(), CarritoActivity.class);
                intent.putExtra("ProductosAgregados",(ArrayList<ResponseProducto>)lista);
                requireActivity().startActivity(intent);
            }
        });

        return binding.getRoot();
    }
}

