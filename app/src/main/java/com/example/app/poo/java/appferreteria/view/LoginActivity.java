package com.example.app.poo.java.appferreteria.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.app.poo.java.appferreteria.R;
import com.example.app.poo.java.appferreteria.databinding.ActivityLoginBinding;
import com.example.app.poo.java.appferreteria.retrofit.request.RequestLogin;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseLogin;
import com.example.app.poo.java.appferreteria.viewmodel.LoginViewModel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener  {

    private ActivityLoginBinding binding;
    private LoginViewModel loginViewModel;
    Context context            ;
    List<RequestLogin> listaLogin= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnlogin.setOnClickListener(this);
        binding.btnregistrar.setOnClickListener(this);
        loginViewModel= new ViewModelProvider(this)
                .get(LoginViewModel.class);
        loginViewModel.loginMutableLiveData.observe(this,
                new Observer<ResponseLogin>() {
                    @Override
                    public void onChanged(ResponseLogin responseLogin) {
                        validarAutentificacion(responseLogin);
                    }
                });
    }

    private void validarAutentificacion(ResponseLogin responseLogin) {
        if(responseLogin.getRpta()){
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            intent.putExtra("usuario", responseLogin);
            startActivity(intent);
        }else{
            Toast.makeText(this,responseLogin.getMensaje(),
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnlogin)
        {
            autenticarUsuario();
        }else{startActivity(new Intent(LoginActivity.this,
                RegistrarUsuarioActivity.class));
        }

    }
    public void autenticarUsuario(){
        RequestLogin requestLogin = new RequestLogin();
        requestLogin.setUsuario(binding.etusuario.getText().toString());
        requestLogin.setContrasenia(binding.etpassword.getText().toString());
        loginViewModel.autenticarUsuario(requestLogin);


    }
}