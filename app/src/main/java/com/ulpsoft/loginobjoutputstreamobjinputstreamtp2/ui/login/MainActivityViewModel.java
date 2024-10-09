package com.ulpsoft.loginobjoutputstreamobjinputstreamtp2.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.ulpsoft.loginobjoutputstreamobjinputstreamtp2.model.Usuario;
import com.ulpsoft.loginobjoutputstreamobjinputstreamtp2.request.ApiClient;
import com.ulpsoft.loginobjoutputstreamobjinputstreamtp2.ui.registro.RegistroActivity;

public class MainActivityViewModel extends AndroidViewModel {

    private Context context;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public void login(String mail, String password){

        if (mail.isEmpty() || password.isEmpty()) {
            // Mostrar Toast de error
            Toast.makeText(context, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }


        Usuario usuarioEncontrado = ApiClient.login(context, mail, password);

        if(usuarioEncontrado != null){
            Intent intent = new Intent(context, RegistroActivity.class);
            intent.putExtra("esRegistro", false);  // Enviar el mismo boolean para que exista en ambos casos
            intent.putExtra("usuario", usuarioEncontrado);  // Enviar el objeto Usuario
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }else{
            Toast.makeText(context, "Datos incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}

