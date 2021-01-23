package com.yorkdecorsoftware.chefsstation.persistence;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "etiqueta")
public class EtiquetaVO {

    @PrimaryKey(autoGenerate = true)
    public int etq_uid;

    @ColumnInfo
    public int rec_uid;

    @ColumnInfo(index = true)
    public String descricao;
}
