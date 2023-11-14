package com.karen.fucapilab.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.karen.fucapilab.R;
import com.karen.fucapilab.dao.AppDatabase;
import com.karen.fucapilab.dao.ReservaDAO;
import com.karen.fucapilab.model.Reserva;

public class CadastroActivity extends AppCompatActivity {

    private ReservaDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppDatabase db = AppDatabase.getDbInstance(this);
        dao  = db.reservaDao();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_activity);
    }
    public void Sair(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    public void Confirmar(View view) {
        Intent intent = new Intent(this, ConfirmActivity.class);

        EditText inputSolicite = findViewById(R.id.idsolicite);
        EditText inputDisciplina = findViewById((R.id.idDisciplina));
        EditText inputTurma = findViewById(R.id.idTrma);
        EditText inputLab = findViewById(R.id.id_lab);
        EditText inputDate = findViewById(R.id.id_Date);

        String solicitante =  inputSolicite.getText().toString();
        String disciplina = inputDisciplina.getText().toString();
        String turma = inputTurma.getText().toString();
        String lab = inputLab.getText().toString();
        String date = inputDate.getText().toString();

        intent.putExtra("Laboratorio",lab);
        intent.putExtra("Data",date);
        intent.putExtra("Turma",turma);
        intent.putExtra("Solicitante", solicitante);
        intent.putExtra("Disciplina", disciplina);

        dao.add(new Reserva(solicitante,turma,lab,date, disciplina));

        startActivity(intent);
    }

}