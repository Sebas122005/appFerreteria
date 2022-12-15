package com.example.app.poo.java.appferreteria.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.app.poo.java.appferreteria.databinding.ActivityReservaBinding;

public class ReservaActivity extends AppCompatActivity {

    ActivityReservaBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReservaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}