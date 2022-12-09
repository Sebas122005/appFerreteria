package com.example.app.poo.java.appferreteria.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app.poo.java.appferreteria.databinding.ItemProductoBinding;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseProducto;
import com.example.app.poo.java.appferreteria.view.DetalleProductoActivity;
import com.example.app.poo.java.appferreteria.view.fragments.CarritoFragment;
import com.example.app.poo.java.appferreteria.view.fragments.InicioFragment;

import java.util.ArrayList;
import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder>{

    private List<ResponseProducto> listaProductos;
    public List<ResponseProducto> listaCarito;
    private Context context;

    public ProductoAdapter(Context context) {
        this.listaProductos = new ArrayList<>();
        this.context = context;
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
                if(listaCarito.contains(obj)){
                    listaCarito.add(obj);
                    holder.binding.btnAgregar.setText("Quitar del Carrito");
                }
                else {
                    listaCarito.remove(obj);
                    holder.binding.btnAgregar.setText("");
                }
                Intent intent = new Intent(context,CarritoFragment.class);
                intent.putExtra("listaCarrito",(ArrayList<ResponseProducto>)listaCarito);
            }
        });

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
