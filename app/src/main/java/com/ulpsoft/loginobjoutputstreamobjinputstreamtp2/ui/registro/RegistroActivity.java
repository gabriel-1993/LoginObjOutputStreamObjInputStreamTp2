package com.ulpsoft.loginobjoutputstreamobjinputstreamtp2.ui.registro;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.ulpsoft.loginobjoutputstreamobjinputstreamtp2.R;
import com.ulpsoft.loginobjoutputstreamobjinputstreamtp2.databinding.ActivityRegistroBinding;
import com.ulpsoft.loginobjoutputstreamobjinputstreamtp2.model.Usuario;

public class RegistroActivity extends AppCompatActivity {

    private ActivityRegistroBinding binding;
    private RegistroActivityViewModel mv;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroActivityViewModel.class);
        context = getApplicationContext();

        // Obtenet boolean para saber si es registro o login, false es el valor  por defecto para no tener el dato vacio
        //(de todas formas siempre llega un valor es el unico boolean para ambos casos)
        boolean esRegistro = getIntent().getBooleanExtra("esRegistro", false);

        if (!esRegistro) {
            //recuperar usuario para mostrar sus datos
            Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");
            binding.etDni.setText(String.valueOf(usuario.getDni()));
            binding.etApellido.setText(usuario.getApellido());
            binding.etNombre.setText(usuario.getNombre());
            binding.etMail.setText(usuario.getMail());
            binding.etPass.setText(usuario.getPassword());
            Toast.makeText(context, "¡ Bienvenido !", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Por favor ingrese todos los datos para crear un usuario.", Toast.LENGTH_SHORT).show();
        }

        binding.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mv.crear(binding.etDni.getText().toString(),
                        binding.etApellido.getText().toString(),
                        binding.etNombre.getText().toString(),
                        binding.etMail.getText().toString(),
                        binding.etPass.getText().toString());
            }
        });
    }

    }

