package com.yorkdecorsoftware.chefsstation.ui.ingrediente;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;

import com.google.android.material.snackbar.Snackbar;
import com.yorkdecorsoftware.chefsstation.R;
import com.yorkdecorsoftware.chefsstation.Utils;
import com.yorkdecorsoftware.chefsstation.databinding.FragmentIngredienteItemBinding;
import com.yorkdecorsoftware.chefsstation.persistence.IngredienteVO;
import com.yorkdecorsoftware.chefsstation.persistence.IngredienteVO;

import java.io.File;
import java.util.ArrayList;

public class IngredienteFragmentAdapter extends ArrayAdapter<IngredienteVO> {
    private FragmentIngredienteItemBinding binding;
    
    public IngredienteFragmentAdapter(Context context, ArrayList<IngredienteVO> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_ingrediente_item, parent, false);
        }

        binding = FragmentIngredienteItemBinding.inflate(LayoutInflater.from(getContext()), parent, false);
        View view = binding.getRoot();
        // Get the data item for this position
        IngredienteVO item = getItem(position);

//        binding.descricao.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                item.descricao = s.toString();
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
        binding.texto.setText( "Item " + Utils.completarString((position + 1), 2, "0"));
        binding.descricao.setText(item.descricao);
        return view;
    }
}
