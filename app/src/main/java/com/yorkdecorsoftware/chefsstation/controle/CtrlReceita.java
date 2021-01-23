package com.yorkdecorsoftware.chefsstation.controle;

import android.content.Context;

import androidx.room.Room;

import com.yorkdecorsoftware.chefsstation.Mensagem;
import com.yorkdecorsoftware.chefsstation.Utils;
import com.yorkdecorsoftware.chefsstation.database.AppDatabase;
import com.yorkdecorsoftware.chefsstation.persistence.ReceitaVO;

import java.util.List;

public class CtrlReceita {

    private AppDatabase db = null;
    private static CtrlReceita instance = null;

    private CtrlReceita(Context context) {
        db = Room.databaseBuilder(context, AppDatabase.class, "chefstation").fallbackToDestructiveMigration().allowMainThreadQueries().build();
    }

    public static CtrlReceita getInstance(Context context){
        if(instance == null)
            instance = new CtrlReceita(context);
        return instance;
    }

    public Mensagem insertAll(ReceitaVO... receitas){
        Mensagem msm = new Mensagem();
        msm.setMensagem("Receita atualizada com sucesso!");
        for (ReceitaVO receita: receitas) {
            if( ! Utils.validaObjeto(receita.getTitulo())){
                msm.set("Informe o título!", false, "a");
                msm.setFoco("titulo");
                return msm;
            }
        }
        db.receitaDao().insertAll(receitas);
        return msm;
    }

    public Mensagem  updateAll(ReceitaVO... receitas){
        Mensagem msm = new Mensagem();
        msm.setMensagem("Receita atualizada com sucesso!");
        for (ReceitaVO receita: receitas) {
            if( ! Utils.validaObjeto(receita.getTitulo())){
                msm.set("Informe o título!", false, "a");
                msm.setFoco("titulo");
                return msm;
            }
        }
        db.receitaDao().updateAll(receitas);
        return msm;
    }
    public List<ReceitaVO> getAll(){
        return db.receitaDao().getAll();
    }

    public List<ReceitaVO> loadAllByIds(int[] receitasIds){
        return db.receitaDao().loadAllByIds(receitasIds);
    }

    public ReceitaVO loadById(int rec_uid){
        return db.receitaDao().loadById(rec_uid);
    }

    public void delete(ReceitaVO receita){
        db.receitaDao().insertAll(receita);
    }
}
