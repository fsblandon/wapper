package com.fsblandon.wapper.vista;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.fsblandon.wapper.R;
import com.fsblandon.wapper.presentador.UsuarioRegistro;

import java.io.File;

import static java.lang.Integer.parseInt;

public class Registro extends ActionBarActivity {

    private EditText nombre;
    private EditText cedula;
    private EditText direccion;
    private EditText correo;
    private EditText movil;
    private EditText password;
    private Button btnRegistro;

    private UsuarioRegistro presentadorR = new UsuarioRegistro(this);

    String nom = "";
    Integer cc = null;
    String dir = "";
    String mail = "";
    Integer cel = null;
    String pw = "";

    public static final int TOMAR_FOTO = 1;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = (EditText) findViewById(R.id.nombre);
        cedula = (EditText) findViewById(R.id.cedula);
        direccion = (EditText) findViewById(R.id.direccion);
        correo = (EditText) findViewById(R.id.correo);
        movil = (EditText) findViewById(R.id.movil);
        password = (EditText) findViewById(R.id.contrasena);
        btnRegistro = (Button) findViewById(R.id.btn_registrov);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nom = nombre.getText().toString();
                cc = parseInt(cedula.getText().toString());
                dir = direccion.getText().toString();
                mail = correo.getText().toString();
                cel = parseInt(movil.getText().toString());
                pw = password.getText().toString();

                Intent intento = new Intent(Registro.this,Home.class);

                if((presentadorR.registrov(nom,cc,dir,mail,cel,pw)) == true){
                    startActivity(intento);
                    return;
                }

            }
        });
    }

    //@Override
    /*protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        super.onResume();
        Intent cameraIntent =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri output = Uri.fromFile(new File("cedula.jpg"));
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,output);
        startActivityForResult(cameraIntent, TOMAR_FOTO);

    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TOMAR_FOTO){
            Bitmap foto = (Bitmap) data.getExtras().get("data");
            img.setImageBitmap(foto);
        }

    }
    /*public void lanzarHome(View view){
        Intent intento = new Intent(this,Home.class);
        startActivity(intento);
    }*/

    public void onSignupSuccess() {
        btnRegistro.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), R.string.registro_failed, Toast.LENGTH_LONG).show();
        btnRegistro.setEnabled(true);
    }



    /*public void lanzarCamara(View view){
        Intent intento = new Intent(this,camara.class);
        startActivity(intento);
    }*/

}
