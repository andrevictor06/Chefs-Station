package com.yorkdecorsoftware.chefsstation.ui.receita;

import androidx.fragment.app.Fragment;

import com.yorkdecorsoftware.chefsstation.R;
import com.yorkdecorsoftware.chefsstation.ui.fotocapa.FotoCapaFragment;
import com.yorkdecorsoftware.chefsstation.ui.ingrediente.IngredienteFragment;
import com.yorkdecorsoftware.chefsstation.ui.modopreparo.ModoPreparoFragment;

public enum TabsReceita {

    PRINCIPAL(R.string.receita_principal,   R.layout.fragment_receita_tab, ReceitaFragmentTab.class),
    INGREDIENTES(R.string.receita_ingredientes,          R.layout.fragment_ingredientes_tab, IngredienteFragment.class),
    MODOPREPARO(R.string.receita_modo_preparo,        R.layout.fragment_modo_preparo_tab, ModoPreparoFragment.class),
    CAPA(R.string.receita_imagens,        R.layout.fragment_fotos_tab, FotoCapaFragment.class),
    ETIQUETAS(R.string.receita_etiquetas,        R.layout.fragment_modo_preparo_tab, IngredienteFragment.class);

    private int mTitleResId;
    private int mLayoutResId;
    private Class<? extends Fragment> mClasse;

    TabsReceita(int titleResId, int layoutResId, Class<? extends Fragment> classe) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
        mClasse = classe;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

    public Class<? extends Fragment> getClasse(){return mClasse;}
}
