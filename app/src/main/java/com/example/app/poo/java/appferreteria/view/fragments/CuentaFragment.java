package com.example.app.poo.java.appferreteria.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import com.example.app.poo.java.appferreteria.databinding.FragmentCuentaBinding;
import com.example.app.poo.java.appferreteria.R;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseLogin;
import com.example.app.poo.java.appferreteria.view.LoginActivity;
public class CuentaFragment extends Fragment {
    private FragmentCuentaBinding binding;
    ResponseLogin response;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("keyInfo", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                response = result.getParcelable("keyInfo");
                System.out.println("Usuario " + response.getUsuario());
            }
        });
    }
}