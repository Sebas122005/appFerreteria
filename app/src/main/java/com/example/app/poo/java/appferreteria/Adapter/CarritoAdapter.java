package com.example.app.poo.java.appferreteria.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app.poo.java.appferreteria.databinding.ItemProductoAgregadoBinding;
import com.example.app.poo.java.appferreteria.databinding.ItemProductoBinding;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseProducto;

import java.util.List;

public class CarritoAdapter extends RecyclerView.Adapter<CarritoAdapter.ViewHolder>{

    private List<ResponseProducto> listaCarrito;
    private Context context;

    public CarritoAdapter(Context context,List<ResponseProducto> lista) {
        this.listaCarrito = lista;
        this.context = context;
    }
    @NonNull
    @Override
    public CarritoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CarritoAdapter.ViewHolder(ItemProductoAgregadoBinding
                .inflate(LayoutInflater
                        .from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CarritoAdapter.ViewHolder holder, int position) {
        final ResponseProducto obj = listaCarrito.get(position);
        holder.binding.txtNombreProducto.setText(obj.getNom_producto().toString());
        holder.binding.txtPUnitario.setText(obj.getPrecio().toString());
        Glide.with(holder.binding.getRoot()).load(obj.getImagen()).into(
                holder.binding.imgProducto);
        holder.binding.btnQuitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaCarrito.remove(obj);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaCarrito.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemProductoAgregadoBinding binding;
        public ViewHolder(@NonNull ItemProductoAgregadoBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
