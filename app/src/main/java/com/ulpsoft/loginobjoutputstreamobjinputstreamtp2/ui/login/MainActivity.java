package com.ulpsoft.loginobjoutputstreamobjinputstreamtp2.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.ulpsoft.loginobjoutputstreamobjinputstreamtp2.R;
import com.ulpsoft.loginobjoutputstreamobjinputstreamtp2.databinding.ActivityMainBinding;
import com.ulpsoft.loginobjoutputstreamobjinputstreamtp2.ui.registro.RegistroActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainActivityViewModel mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        binding.btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo = binding.etUserIngreso.getText().toString();
                String password = binding.etPassIngreso.getText().toString();
                mv.login(correo, password);
            }
        });


        binding.btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, RegistroActivity.class);
                intent.putExtra("esRegistro", true);  // Enviar un boolean para indicar registro
                startActivity(intent);
            }
        });

    }



}