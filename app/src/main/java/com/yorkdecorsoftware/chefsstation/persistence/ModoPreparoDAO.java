package com.yorkdecorsoftware.chefsstation.persistence;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ModoPreparoDAO {

    @Query("SELECT * FROM modopreparo")
    List<ModoPreparoVO> getAll();

    @Query("SELECT * FROM modopreparo WHERE mod_uid IN (:uIds)")
    List<ModoPreparoVO> loadAllByIds(int[] uIds);

    @Insert
    long[] insertAll(ModoPreparoVO... lista);

    @Delete
    int delete(ModoPreparoVO item);

    @Update
    int update(ModoPreparoVO item);
}

