package com.yorkdecorsoftware.chefsstation.persistence;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ReceitaDAO {

    @Query("SELECT * FROM receita")
    List<ReceitaVO> getAll();

    @Query("SELECT * FROM receita WHERE rec_uid IN (:uIds)")
    List<ReceitaVO> loadAllByIds(int[] uIds);

    @Query("SELECT * FROM receita WHERE rec_uid IN (:rec_uid)")
    ReceitaVO loadById(int rec_uid);

    @Insert
    long[] insertAll(ReceitaVO... receitas);

    @Delete
    int delete(ReceitaVO receita);

    @Update
    int updateAll(ReceitaVO... receitas);
}
