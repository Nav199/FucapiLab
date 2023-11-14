package com.karen.fucapilab.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.karen.fucapilab.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login_activity);
    }
    public void entrar(View view) { //ENTRAR EM OUTRA PÁGINA (PÁGINA DE FAZER RESERVA)
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}