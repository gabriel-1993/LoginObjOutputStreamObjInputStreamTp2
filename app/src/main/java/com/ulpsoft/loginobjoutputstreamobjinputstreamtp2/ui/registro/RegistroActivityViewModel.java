package com.ulpsoft.loginobjoutputstreamobjinputstreamtp2.ui.registro;


import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.ulpsoft.loginobjoutputstreamobjinputstreamtp2.model.Usuario;
import com.ulpsoft.loginobjoutputstreamobjinputstreamtp2.request.ApiClient;
import com.ulpsoft.loginobjoutputstreamobjinputstreamtp2.ui.login.MainActivity;

public class RegistroActivityViewModel extends AndroidViewModel {

    private Context context;

    public RegistroActivityViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }

    public void crear(String dni, String apellido, String nombre, String email, String password){
        long dniLong = Long.parseLong(dni);
        Usuario usuario = new Usuario(dniLong, apellido, nombre, email, password);

        ApiClient.Guardar(context, usuario);

        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

        // Toast.makeText(context, "Datos incorrectos", Toast.LENGTH_SHORT).show();

    }

}
