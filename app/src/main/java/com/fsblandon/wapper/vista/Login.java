package com.fsblandon.wapper.vista;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.fsblandon.wapper.R;

import com.fsblandon.wapper.R;
import com.fsblandon.wapper.modelo.Usuario;
import com.fsblandon.wapper.presentador.UsuarioLogin;

import static com.fsblandon.wapper.R.*;

public class Login extends ActionBarActivity {

    private EditText inputID;
    private EditText inputPass;
    private Button btnLogin;

    Integer ID = null;
    String passw = "";

    private UsuarioLogin presentador = new UsuarioLogin(this);

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_login);

        inputID = (EditText) findViewById(R.id.login_user);
        inputPass = (EditText) findViewById(R.id.login_pass);
        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ID = Integer.parseInt(inputID.getText().toString());
                passw = inputPass.getText().toString();

                Intent intento = new Intent(Login.this,Home.class);
                /*Bundle b = new Bundle();
                b.putInt("id",ID);
                b.putString("contraseña",pass);
                intento.putExtras(b);*/

                //presentador.loginv();
                if ((presentador.loginv(ID,passw)) == true){
                    startActivity(intento);
                }

                //startActivity(intento);
                //lanzarHome(view);

            }
        });


    }

    /*public void lanzarHome(View view){
        Intent intento = new Intent(this,Home.class);
        this.startActivity(intento);
    }*/

    /*public void loginv(View view){
        String tag = "LoginActivity";
        Log.d(tag,"Login");

        if(!validate()){
            onLoginFailed();
            return;
        }

        btnLogin.setEnabled(false);

        final ProgressDialog dialogo = new ProgressDialog(Login.this, style.Base_Theme_AppCompat_Light_DarkActionBar);
        dialogo.setIndeterminate(true);
        dialogo.setMessage("Autenticando...");
        dialogo.show();

        String ID = inputID.getText().toString();
        String pass = inputPass.getText().toString();

        Intent intento = new Intent(this,Home.class);
        startActivity(intento);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        onLoginSuccess();
                        dialogo.dismiss();
                    }
                },3000);

    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == 1){
                //implementar lo que viene despues de login exitoso
                this.finish();
            }
        }
    }

    //@Override
    //public void onBackPressed() {
    //    super.onBackPressed();
    //    moveTaskToBack(true);
    //}


    public void onLoginSuccess(){
        btnLogin.setEnabled(true);
        finish();
    }

    public void onLoginFailed(){
        Toast.makeText(getBaseContext(), string.login_failed,Toast.LENGTH_SHORT).show();
        btnLogin.setEnabled(true);
    }

    /*public boolean validate(){
        boolean valid = true;

        String ID = inputID.getText().toString();
        String pass = inputPass.getText().toString();

        if (ID.isEmpty()){
            Toast.makeText(getBaseContext(), string.error_usuario,Toast.LENGTH_SHORT).show();
        }
        else{
            inputID.setError(null);
        }

        if (pass.isEmpty() || pass.length() < 4 || pass.length() > 10){
            Toast.makeText(getBaseContext(), string.error_contraseña,Toast.LENGTH_SHORT).show();
        }
        else {
            inputPass.setError(null);
        }

        return valid;
    }*/
}
