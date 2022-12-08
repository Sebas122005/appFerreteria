package com.example.app.poo.java.appferreteria.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.app.poo.java.appferreteria.R;
import com.example.app.poo.java.appferreteria.databinding.ActivityDetalleProductoBinding;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseProducto;

public class DetalleProductoActivity extends AppCompatActivity {

    ActivityDetalleProductoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetalleProductoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if(getIntent().hasExtra("producto")){
            ResponseProducto objProducto = getIntent().getParcelableExtra("producto");
            Glide.with(binding.getRoot()).load(objProducto.getImagen()).into(binding.imgProductoDetalle);
            binding.txtNomProductoDetalle.setText("Producto : "+objProducto.getNom_producto().toString());
            binding.txtDescProductoDetalle.setText("Descripción : "+objProducto.getDescripcion().toString());
            binding.txtCategoriaDetalle.setText("Categoria : "+objProducto.getId_categoria().toString());
            binding.txtStockDetalle.setText("Stock : "+objProducto.getStock().toString());
            binding.txtPrecioDetalle.setText("Precio : "+objProducto.getPrecio().toString());
        }

        binding.btnRegresarDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetalleProductoActivity.this,MainActivity.class));
            }
        });
        binding.btnAgregarProductoDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}