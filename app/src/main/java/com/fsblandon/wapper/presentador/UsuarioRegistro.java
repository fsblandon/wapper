package com.fsblandon.wapper.presentador;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import com.fsblandon.wapper.R;
import com.fsblandon.wapper.modelo.Usuario;
import com.fsblandon.wapper.vista.Registro;

import java.io.File;

/**
 * Created by fsblandon on 7/20/16.
 */
public class UsuarioRegistro {

    public Registro registro;

    public UsuarioRegistro(Registro registro){
        this.registro = registro;
    }

    public boolean registrov(String nombre,Integer cc,String direccion, String correo,Integer celular,String password){

        String tag = "RegistroActivity";
        Log.d(tag,"Registro");

        if (!validate(nombre,cc,direccion,correo,celular,password)) {
            registro.onSignupFailed();
            return false;
        }

        //_signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(registro, R.style.Base_Theme_AppCompat_Light);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creando cuenta...");
        progressDialog.show();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        registro.onSignupSuccess();
                        progressDialog.dismiss();
                    }
                }, 3000);


        return true;
    }

    public boolean validate(String nombre,Integer cedula,String dir,String email,Integer movil,String pass){
        boolean valid = true;

        Usuario usuario = new Usuario();

        if (cedula.toString().isEmpty() && (cedula < 2 || cedula>10)){
            Toast.makeText(registro.getBaseContext(),R.string.error_cedula,Toast.LENGTH_SHORT).show();
            valid = false;
        }else{
            usuario.setID(cedula);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(registro.getBaseContext(),R.string.error_correo_invalido,Toast.LENGTH_SHORT).show();
            valid = false;
        } else {
            usuario.setCorreo(email);
        }

        if (pass.isEmpty() && (pass.length() < 4 || pass.length() > 10)) {
            Toast.makeText(registro.getBaseContext(),R.string.error_contraseña,Toast.LENGTH_SHORT).show();
            valid = false;
        } else {
           usuario.setPassword(pass);
        }

        usuario.setNombre(nombre);
        usuario.setDireccion(dir);
        usuario.setMovil(movil);

        Toast.makeText(registro.getBaseContext(),R.string.registro_completo,Toast.LENGTH_SHORT).show();

        return valid;

    }
}
