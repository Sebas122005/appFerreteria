package com.example.app.poo.java.appferreteria.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.poo.java.appferreteria.R;
import com.example.app.poo.java.appferreteria.databinding.FragmentCarritoBinding;


public class CarritoFragment extends Fragment {

    FragmentCarritoBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentCarritoBinding.inflate(inflater, container, false);



        return  binding.getRoot();
    }
}