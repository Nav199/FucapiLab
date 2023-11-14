package com.karen.fucapilab.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.karen.fucapilab.model.Reserva;

import java.util.List;

@Dao
public interface ReservaDAO {

    @Query("SELECT * FROM reserva")
    List<Reserva> getAll();

    @Insert
    void add(Reserva reserva);

    @Delete
    void delete(Reserva user);
}
