package com.yorkdecorsoftware.chefsstation.persistence;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "modopreparo")
public class ModoPreparoVO {

   @PrimaryKey(autoGenerate = true)
   public int mod_uid;

   @ColumnInfo
   public int rec_uid;

   @ColumnInfo(index = true)
   public String descricao;
}

