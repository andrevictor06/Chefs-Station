package com.yorkdecorsoftware.chefsstation.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.yorkdecorsoftware.chefsstation.persistence.EtiquetaDAO;
import com.yorkdecorsoftware.chefsstation.persistence.EtiquetaVO;
import com.yorkdecorsoftware.chefsstation.persistence.IngredienteDAO;
import com.yorkdecorsoftware.chefsstation.persistence.IngredienteVO;
import com.yorkdecorsoftware.chefsstation.persistence.ModoPreparoDAO;
import com.yorkdecorsoftware.chefsstation.persistence.ModoPreparoVO;
import com.yorkdecorsoftware.chefsstation.persistence.ReceitaDAO;
import com.yorkdecorsoftware.chefsstation.persistence.ReceitaVO;

@Database(entities = {ReceitaVO.class, IngredienteVO.class, ModoPreparoVO.class, EtiquetaVO.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ReceitaDAO receitaDao();

    public abstract IngredienteDAO ingredienteDao();

    public abstract ModoPreparoDAO modoPreparoDAO();

    public abstract EtiquetaDAO etiquetaDAO();
}
