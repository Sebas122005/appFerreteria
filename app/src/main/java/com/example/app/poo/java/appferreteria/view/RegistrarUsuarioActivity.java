package com.example.app.poo.java.appferreteria.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.app.poo.java.appferreteria.R;
import com.example.app.poo.java.appferreteria.databinding.ActivityRegistrarUsuarioBinding;
import com.example.app.poo.java.appferreteria.retrofit.request.RequestRegistro;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseRegistro;
import com.example.app.poo.java.appferreteria.viewmodel.LoginViewModel;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Date;

public class RegistrarUsuarioActivity extends AppCompatActivity implements
        View.OnClickListener{
    private ActivityRegistrarUsuarioBinding binding;
    private LoginViewModel loginViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrarUsuarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding.btnirlogin.setOnClickListener(this);
        binding.btnregistro.setOnClickListener(this);
        loginViewModel.registroMutableLiveData.observe(this,
                new Observer<ResponseRegistro>() {
                    @Override
                    public void onChanged(ResponseRegistro responseRegistro) {
                        validarRegistroUsuario(responseRegistro);
                    }
                });
    }

    private void validarRegistroUsuario(ResponseRegistro responseRegistro) {
        Toast.makeText(getApplicationContext(),
                responseRegistro.getMensaje(),
                Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnirlogin){
            startActivity(new Intent(RegistrarUsuarioActivity.this,
                    LoginActivity.class));
        }else{
            registrarUsuario();
        }

    }
    private String obtenerGenero(){
        String genero="";
        switch (binding.rggenero.getCheckedRadioButtonId()){
            case R.id.btnmasculino: genero= binding.btnmasculino.getText().toString().trim();break;
            case R.id.btnfemenino: genero= binding.btnfemenino.getText().toString().trim();break;
        }
        return genero;
    }

    private void registrarUsuario() {
        RequestRegistro requestRegistro = new RequestRegistro();
        requestRegistro.setNombres(binding.etnombreregistro.getText().toString());
        requestRegistro.setApe_paterno(binding.valapematerno.getText().toString());
        requestRegistro.setApe_materno(binding.valapematerno.getText().toString());
        requestRegistro.setDni(binding.valdni.getText().toString());
        requestRegistro.setSexo(obtenerGenero());
        requestRegistro.setDireccion(binding.valdireccion.getText().toString());
        requestRegistro.setFoto("");
        Date date = new Date();
        requestRegistro.setFecha_nacimiento(binding.valetfecha.getText().toString());
        requestRegistro.setCorreo(binding.valcorreo.getText().toString());
        requestRegistro.setNum_celular(binding.valcelular.getText().toString());
        requestRegistro.setTelefono(binding.valtelefono.getText().toString());
        requestRegistro.setUsuario(binding.valusuario.getText().toString());
        requestRegistro.setContrasenia(binding.valcontrasena.getText().toString());
        loginViewModel.registrarUsuario(requestRegistro);
    }
}