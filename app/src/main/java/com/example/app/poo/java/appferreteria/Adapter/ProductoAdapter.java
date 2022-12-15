package com.example.app.poo.java.appferreteria.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.app.poo.java.appferreteria.databinding.ItemProductoBinding;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseProducto;
import com.example.app.poo.java.appferreteria.view.DetalleProductoActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder>{

    private List<ResponseProducto> listaProductos;
    private List<ResponseProducto> listaCarrito;
    private Context context;

    public ProductoAdapter(Context context,List<ResponseProducto> lista) {
        this.listaProductos = new ArrayList<>();
        this.context = context;
        this.listaCarrito = lista;
    }

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
        holder.binding.txtNombreProducto.setText("Producto : "+obj.getNom_producto().toString());
        holder.binding.txtPrecio.setText("Precio : "+obj.getPrecio().toString());
        holder.binding.txtStock.setText("Stock : "+obj.getStock().toString());
        Glide.with(holder.binding.getRoot()).
                load(obj.getImagen()).
                into(holder.binding.imgProducto);
        holder.binding.btnDetalleProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetalleProductoActivity.class);
                intent.putExtra("producto",obj);
                context.startActivity(intent);
            }
        });

        holder.binding.btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listaCarrito.contains(obj)){
                    listaCarrito.remove(obj);
                    holder.binding.btnAgregar.setText("Agregar al Carrito");
                }else {
                    listaCarrito.add(obj);
                    holder.binding.btnAgregar.setText("Quitar del Carrito");
                }
                System.out.println("Lista : "+listaCarrito.size());
            }
        });
    }

    public List<ResponseProducto> setListaCarrito(List<ResponseProducto> list){
        this.listaCarrito.addAll(list);
        notifyDataSetChanged();
        return listaCarrito;
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
