package com.yorkdecorsoftware.chefsstation.persistence;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface IngredienteDAO {

    @Query("SELECT * FROM ingrediente")
    List<IngredienteVO> getAll();

    @Query("SELECT * FROM ingrediente WHERE igr_uid IN (:uIds)")
    List<IngredienteVO> loadAllByIds(int[] uIds);

    @Insert
    long[] insertAll(IngredienteVO... ingredientes);

    @Delete
    int delete(IngredienteVO ingrediente);

    @Update
    int update(IngredienteVO ingrediente);
}

