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
                System.out.println("Usuario "+response.getUsuario());
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCuentaBinding.inflate(inflater,container,false);
        binding.imgcuenta.setImageResource(R.drawable.img_user);
        binding.txtNombre.setText(response.getNombres());
        binding.btnsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
