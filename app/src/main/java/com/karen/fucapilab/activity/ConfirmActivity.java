package com.karen.fucapilab.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.karen.fucapilab.R;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.confirm_activity);

        TextView Solicitante = findViewById(R.id.idtext3);
        TextView Disciplina = findViewById(R.id.textView8);
        TextView Turma = findViewById(R.id.idtext04);
        TextView Laboratorio = findViewById(R.id.id_lab05);
        TextView Date = findViewById(R.id.textView9);

        Intent intent = getIntent();

        String Dat = intent.getStringExtra("Data");
        Date.setText("Data: "+Dat+"");
        String Lab = intent.getStringExtra("Laboratorio");
        Laboratorio.setText("Laborátorio: "+Lab+"");
        String Trma = intent.getStringExtra("Turma");
        Turma.setText("Turma: "+Trma+"");
        String Soli = intent.getStringExtra("Solicitante");
        Solicitante.setText("Solicitante: " + Soli + "");
        String Dis = intent.getStringExtra("Disciplina");
        Disciplina.setText("Disciplina: "+Dis+"");
        /*
        Recebe os dados da activity 3, para mostra-las neste XML
        */
    }
    public void Retornar(View view) { // Retorna para a página de Fazer Reservas a MainActivity2
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}