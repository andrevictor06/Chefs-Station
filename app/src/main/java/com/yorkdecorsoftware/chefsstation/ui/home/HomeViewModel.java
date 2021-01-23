package com.yorkdecorsoftware.chefsstation.ui.home;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yorkdecorsoftware.chefsstation.controle.CtrlReceita;
import com.yorkdecorsoftware.chefsstation.persistence.ReceitaVO;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    private ReceitaVO receita;

    public HomeViewModel() {

        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}