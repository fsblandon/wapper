package com.fsblandon.wapper.presentador;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fsblandon.wapper.R;
import com.fsblandon.wapper.modelo.Usuario;
import com.fsblandon.wapper.vista.Home;
import com.fsblandon.wapper.vista.Login;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fsblandon on 7/17/16.
 */
public class UsuarioLogin {

    public Login login;
    //private String passw;
    //private int ID;

    public UsuarioLogin(Login login){
        this.login = login;
    }

    public boolean loginv(Integer id,String pass){
        //usuario.setID(idUsuario);
        //usuario.setPassword(pass);

        String tag = "LoginActivity";
        Log.d(tag,"Login");

        //btnLogin.setEnabled(false);
        if(!validate(id,pass)){
            login.onLoginFailed();
            return false;
        }

        final ProgressDialog dialogo = new ProgressDialog(login, R.style.Base_Theme_AppCompat);
        dialogo.setIndeterminate(true);
        dialogo.setMessage("Autenticando...");
        dialogo.show();

        //String ID = inputID.getText().toString();
        //String pass = inputPass.getText().toString();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        login.onLoginSuccess();
                        dialogo.dismiss();
                    }
                },3000);

        return true;

    }


    /*public void onLoginSuccess(){
        btnLogin.setEnabled(true);
        login.finish();
    }

    public void onLoginFailed(){
        Toast.makeText(login.getBaseContext(), R.string.login_failed,Toast.LENGTH_SHORT).show();
        btnLogin.setEnabled(true);
    }*/

    public boolean validate(Integer idL,String passL){
        boolean valid = true;

        //ArrayList<Usuario> lsUsuarios = new ArrayList<>();
        Usuario usuario = new Usuario();

        Integer id = 12345678;
        String pass = "1234";

        //capturar lo digitado por el usuario
        /*Bundle b = login.getIntent().getExtras();
        Integer idL = b.getInt("id");
        String passL = b.getString("contraseña");*/

        if(idL != id && idL.toString().isEmpty()){
            Toast.makeText(login.getBaseContext(), R.string.error_usuario,Toast.LENGTH_SHORT).show();
            valid = false;
        }
        else{
            usuario.setID(idL);
        }

        if (passL != pass && passL.isEmpty() || (passL.length() < 4 || passL.length() > 10)){
            Toast.makeText(login.getBaseContext(), R.string.error_contraseña,Toast.LENGTH_SHORT).show();
            valid = false;
        }
        else {
            usuario.setPassword(passL);
        }

        //insertar el nuevo usuario en la lista
        //lsUsuarios.add(0,usuario);
        //System.out.println(lsUsuarios);

        return valid;

    }

}
