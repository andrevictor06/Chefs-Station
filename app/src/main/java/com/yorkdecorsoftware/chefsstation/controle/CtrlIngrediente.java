package com.yorkdecorsoftware.chefsstation.controle;

import android.content.Context;

import androidx.room.Room;

import com.yorkdecorsoftware.chefsstation.database.AppDatabase;
import com.yorkdecorsoftware.chefsstation.persistence.IngredienteVO;
import java.util.List;

public class CtrlIngrediente {

    private AppDatabase db = null;
    private static CtrlIngrediente instance = null;

    private CtrlIngrediente(Context context) {
        db = Room.databaseBuilder(context, AppDatabase.class, "chefstation").allowMainThreadQueries().build();
    }

    public static CtrlIngrediente getInstance(Context context){
        if(instance == null)
            instance = new CtrlIngrediente(context);
        return instance;
    }

    public void insertAll(IngredienteVO... itens){db.ingredienteDao().insertAll(itens);
    }

    public List<IngredienteVO> getAll(){
        return db.ingredienteDao().getAll();
    }

    public List<IngredienteVO> loadAllByIds(int[] uIds){
        return db.ingredienteDao().loadAllByIds(uIds);
    }

    public void delete(IngredienteVO item){
        db.ingredienteDao().insertAll(item);
    }
}
