package com.karen.fucapilab.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Reserva {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String solicitante;
    private String turma;
    private String laboratorio;
    private String data;
    private String disciplina;

    public Reserva(String solicitante, String turma, String laboratorio, String data, String disciplina) {
        this.solicitante = solicitante;
        this.turma = turma;
        this.laboratorio = laboratorio;
        this.data = data;
        this.disciplina = disciplina;
    }

    public int getId() {
        return id;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public String getTurma() {
        return turma;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public String getData() {
        return data;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        if(getSolicitante() == "Vazio"){
            return "Nenhum dado cadastrado";
        }
        return "Id= " + id + ", Solicitante= " + solicitante +", Data= " + data + ", Disciplina= " + disciplina;
    }
}
