package com.yorkdecorsoftware.chefsstation.ui.receita;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yorkdecorsoftware.chefsstation.persistence.ReceitaVO;

public class ReceitaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    private ReceitaVO receita;

    public ReceitaViewModel() {

        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}