package com.example.app.poo.java.appferreteria.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.poo.java.appferreteria.Adapter.CarritoAdapter;
import com.example.app.poo.java.appferreteria.databinding.FragmentCarritoBinding;
import com.example.app.poo.java.appferreteria.retrofit.response.ResponseProducto;
import com.example.app.poo.java.appferreteria.view.LoginActivity;
import com.example.app.poo.java.appferreteria.view.MainActivity;
import com.example.app.poo.java.appferreteria.view.ReservaActivity;
import com.example.app.poo.java.appferreteria.viewmodel.ProductoViewModel;

import java.util.ArrayList;
import java.util.List;


public class CarritoFragment extends Fragment {

    FragmentCarritoBinding binding;
    List<ResponseProducto>lista= new ArrayList<>();
    ProductoViewModel viewModel;
    Context context;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            getParentFragmentManager().setFragmentResultListener("key", this, new FragmentResultListener() {
                @Override
                public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                    lista = result.getParcelableArrayList("key");
                    System.out.println("Longitud : " + lista.size() + "Productos" + lista.get(0).getNom_producto());

                }
            });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            binding = FragmentCarritoBinding.inflate(inflater, container, false);
            viewModel = new ViewModelProvider(requireActivity()).get(ProductoViewModel.class);
            binding.rvListaCarrito.setLayoutManager(new LinearLayoutManager(requireActivity()));
            CarritoAdapter adapter = new CarritoAdapter(requireActivity(), lista);
            binding.rvListaCarrito.setAdapter(adapter);
            viewModel.cargarCarrrito(lista);
            viewModel.listCarrMutableLiveData.observe(getViewLifecycleOwner(),
                    new Observer<List<ResponseProducto>>() {
                        @Override
                        public void onChanged(List<ResponseProducto> list) {
                            adapter.setListaCarrito(lista);
                        }
                    });
            binding.btnHacerReserva.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), ReservaActivity.class);
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