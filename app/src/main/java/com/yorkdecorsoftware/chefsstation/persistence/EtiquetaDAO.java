package com.yorkdecorsoftware.chefsstation.persistence;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EtiquetaDAO {

    @Query("SELECT * FROM etiqueta")
    List<EtiquetaVO> getAll();

    @Query("SELECT * FROM etiqueta WHERE etq_uid IN (:uIds)")
    List<EtiquetaVO> loadAllByIds(int[] uIds);

    @Insert
    long[] insertAll(EtiquetaVO... lista);

    @Delete
    int delete(EtiquetaVO item);

    @Update
    int update(EtiquetaVO item);
}

