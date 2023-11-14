package com.karen.fucapilab.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.karen.fucapilab.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.home_activity);
    }
    public void Reserva(View view) { /*
                       ENTRAR EM OUTRA PÁGINA (Página de digitar os dados para cadastro)
                                        */
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }
    public void Visualizar(View view) { // Entra para a página da LISTA
        Intent intent = new Intent(this, Lista_activity.class);
        startActivity(intent);
    }
    public void Exit(View view) { //volta para a tela de login
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
