package com.yorkdecorsoftware.chefsstation.ui.modopreparo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MedidaViewModel  extends ViewModel {
    private MutableLiveData<String> mText;

    public MedidaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is medida fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
