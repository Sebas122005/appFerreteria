package com.example.app.poo.java.appferreteria.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.poo.java.appferreteria.Adapter.CategoriaAdapter;
import com.example.app.poo.java.appferreteria.R;
import com.example.app.poo.java.appferreteria.databinding.FragmentCategoriaBinding;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseCategoria;
import com.example.app.poo.java.appferreteria.viewmodel.CategoriaViewModel;

import java.util.List;


public class CategoriaFragment extends Fragment {

    FragmentCategoriaBinding binding;

    CategoriaViewModel categoriaViewModel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentCategoriaBinding.inflate(inflater, container, false);

        categoriaViewModel = new ViewModelProvider(requireActivity()).get(CategoriaViewModel.class);
        binding.rvListaCategorias.setLayoutManager(new LinearLayoutManager(requireActivity()));

        CategoriaAdapter categoriaAdapter = new CategoriaAdapter();

        binding.rvListaCategorias.setAdapter(categoriaAdapter);
        categoriaViewModel.listarCategorias();
        categoriaViewModel.listCategoriaMutableLiveData.observe(getViewLifecycleOwner(),
                new Observer<List<ResponseCategoria>>() {
                    @Override
                    public void onChanged(List<ResponseCategoria> responseCategorias) {
                        categoriaAdapter.setListaCategoria(responseCategorias);
                    }
                });


        return binding.getRoot();
    }
}