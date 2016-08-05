package com.fsblandon.wapper.vista;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.fsblandon.wapper.R;
import com.fsblandon.wapper.vista.Login;
import com.fsblandon.wapper.vista.Registro;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getActionBar().hide();
        //getSupportActionBar().hide();

        setContentView(R.layout.activity_main);
        //Drawable background = findViewById(R.id.main_back).getBackground();
        //background.setAlpha(0);
    }

    public void registro(View v){
        Intent intento = new Intent(this, Registro.class);
        startActivity(intento);

    }

    public void login(View v){
        Intent intento = new Intent(this, Login.class);
        startActivity(intento);
    }



}
