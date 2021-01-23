package com.yorkdecorsoftware.chefsstation.persistence;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ingrediente")
public class IngredienteVO {

    @PrimaryKey(autoGenerate = true)
    public int igr_uid;

    @ColumnInfo
    public int rec_uid;

    @ColumnInfo(index = true)
    public String descricao;
}
