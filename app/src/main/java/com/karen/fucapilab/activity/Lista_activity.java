package com.karen.fucapilab.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.karen.fucapilab.R;
import com.karen.fucapilab.dao.AppDatabase;
import com.karen.fucapilab.dao.ReservaDAO;
import com.karen.fucapilab.model.Reserva;

public class Lista_activity extends AppCompatActivity {

    private ArrayAdapter<Reserva> adapter;
    private ReservaDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppDatabase db = AppDatabase.getDbInstance(this);
        dao  = db.reservaDao();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.lista_activity);
        configuraFab();
        configuraLista();

    }
    protected void onRestart() {
        super.onRestart();
        atualiza();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_lista_reservas_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.remover){
            AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            Reserva reserva = adapter.getItem(menuInfo.position);
            remove(reserva);
        }
        return super.onContextItemSelected(item);
    }

    private void remove(Reserva reserva) {
        dao.delete(reserva);
        adapter.remove(reserva);
    }

    private void configuraAdapter(ListView listaDeReserva) {
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1);
        listaDeReserva.setAdapter(adapter);
    }

    private void configuraLista() {
        ListView listView = findViewById(R.id.agendamento_listView);
        configuraAdapter(listView);
        registerForContextMenu(listView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualiza();
    }

    private void atualiza() {
        if(dao.getAll().size() == 0){
            adapter.add(new Reserva("Vazio","","","",""));
        }else{
        adapter.clear();
        adapter.addAll(dao.getAll());}
    }
    private void configuraFab() {
        FloatingActionButton voltar = findViewById(R.id.activity_lista_reserva_fab_voltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Retornar();}
        });
    }

    private void Retornar() {
        startActivity(new Intent(this,
                HomeActivity.class));
    }

}