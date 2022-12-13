package com.example.app.poo.java.appferreteria.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.app.poo.java.appferreteria.Adapter.CarritoAdapter;
import com.example.app.poo.java.appferreteria.R;
import com.example.app.poo.java.appferreteria.databinding.ActivityCarritoBinding;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseProducto;

import java.util.ArrayList;

public class CarritoActivity extends AppCompatActivity {

    ActivityCarritoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityCarritoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<ResponseProducto> listaPAgregados = (ArrayList<ResponseProducto>)getIntent().getSerializableExtra("ProductosAgregados");
        CarritoAdapter adapter = new CarritoAdapter(this,listaPAgregados);
        binding.rvListaCarritoActivity.setAdapter(adapter);
    }
}