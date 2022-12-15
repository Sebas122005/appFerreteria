package com.example.app.poo.java.appferreteria.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.app.poo.java.appferreteria.R;
import com.example.app.poo.java.appferreteria.databinding.ActivityMainBinding;
import com.example.app.poo.java.appferreteria.databinding.FragmentCuentaBinding;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseLogin;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseProducto;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.InicioFragment,
                R.id.CategoriaFragment,R.id.CarritoFragment,R.id.CuentaFragment).build();
        NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView,navController);

    }
}

