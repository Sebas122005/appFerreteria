package com.example.app.poo.java.appferreteria.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app.poo.java.appferreteria.R;
import com.example.app.poo.java.appferreteria.databinding.ItemProductoBinding;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseProducto;

import java.util.ArrayList;
import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder>{

    private List<ResponseProducto> listaProductos = new ArrayList<>();


    @NonNull
    @Override
    public ProductoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemProductoBinding
                .inflate(LayoutInflater
                        .from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoAdapter.ViewHolder holder, int position) {
        final ResponseProducto obj = listaProductos.get(position);
        holder.binding.txtNombreProducto.setText(obj.getNom_producto().toString());
        holder.binding.txtPrecio.setText(obj.getPrecio().toString());
        holder.binding.txtStock.setText(obj.getStock().toString());
        Glide.with(holder.binding.getRoot()).
                load(obj.getImagen()).
                into(holder.binding.imgProducto);

    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public void setListaProductos(List<ResponseProducto> lista){
        this.listaProductos.addAll(lista);
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemProductoBinding binding;
        public ViewHolder(ItemProductoBinding itemView) {
            super(itemView.getRoot());
            binding=itemView;
        }
    }
}
