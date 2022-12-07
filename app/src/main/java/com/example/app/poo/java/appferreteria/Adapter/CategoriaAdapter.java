package com.example.app.poo.java.appferreteria.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.poo.java.appferreteria.databinding.ItemProductoBinding;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseCategoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.ViewHolder>{

    private List<ResponseCategoria> listaCategoria = new ArrayList<>();

    @NonNull
    @Override
    public CategoriaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemProductoBinding.inflate
                (LayoutInflater.from
                        (parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull ItemProductoBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
