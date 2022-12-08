package com.example.app.poo.java.appferreteria.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app.poo.java.appferreteria.databinding.ItemCategoriaBinding;
import com.example.app.poo.java.appferreteria.databinding.ItemProductoBinding;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseCategoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.ViewHolder>{

    private List<ResponseCategoria> listaCategoria = new ArrayList<>();

    @NonNull
    @Override
    public CategoriaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemCategoriaBinding.inflate
                (LayoutInflater.from
                        (parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaAdapter.ViewHolder holder, int position) {
        final ResponseCategoria obj = listaCategoria.get(position);
        holder.binding.txtNombreCategoria.setText("Categoria : "+obj.getNom_categoria().toString());
        holder.binding.txtDescripcionCategoria.setText("Descripción : "+obj.getDescripcion().toString());
        Glide.with(holder.binding.getRoot()).load(obj.getImagen()).into(holder.binding.imgCategoria);
    }

    @Override
    public int getItemCount() {
        return listaCategoria.size();
    }

    public void setListaCategoria(List<ResponseCategoria> lista) {
        this.listaCategoria.addAll(lista);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemCategoriaBinding binding;
        public ViewHolder(@NonNull ItemCategoriaBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
