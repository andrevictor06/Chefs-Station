package com.yorkdecorsoftware.chefsstation.ui.modopreparo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.yorkdecorsoftware.chefsstation.R;
import com.yorkdecorsoftware.chefsstation.Utils;
import com.yorkdecorsoftware.chefsstation.databinding.FragmentIngredienteItemBinding;
import com.yorkdecorsoftware.chefsstation.databinding.FragmentModoPreparoItemBinding;
import com.yorkdecorsoftware.chefsstation.persistence.IngredienteVO;
import com.yorkdecorsoftware.chefsstation.persistence.ModoPreparoVO;

import java.util.ArrayList;

public class ModoPreparoFragmentAdapter extends ArrayAdapter<ModoPreparoVO> {
    private FragmentModoPreparoItemBinding binding;

    public ModoPreparoFragmentAdapter(Context context, ArrayList<ModoPreparoVO> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_modo_preparo_item, parent, false);
        }

        binding = FragmentModoPreparoItemBinding.inflate(LayoutInflater.from(getContext()), parent, false);
        View view = binding.getRoot();
        // Get the data item for this position
        ModoPreparoVO item = getItem(position);

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
