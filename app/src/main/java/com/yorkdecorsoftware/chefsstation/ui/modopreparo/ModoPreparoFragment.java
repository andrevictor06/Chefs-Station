package com.yorkdecorsoftware.chefsstation.ui.modopreparo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.yorkdecorsoftware.chefsstation.databinding.FragmentIngredientesTabBinding;
import com.yorkdecorsoftware.chefsstation.databinding.FragmentModoPreparoTabBinding;
import com.yorkdecorsoftware.chefsstation.persistence.IngredienteVO;
import com.yorkdecorsoftware.chefsstation.persistence.ModoPreparoVO;
import com.yorkdecorsoftware.chefsstation.ui.ingrediente.IngredienteFragmentAdapter;

import java.util.ArrayList;


public class ModoPreparoFragment extends Fragment {

    private FragmentModoPreparoTabBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentModoPreparoTabBinding.inflate(inflater, container, false);
        View view = binding.getRoot();



        ArrayList<ModoPreparoVO> lista = new ArrayList<>();
        lista.add(new ModoPreparoVO());
        lista.add(new ModoPreparoVO());
        lista.add(new ModoPreparoVO());
        lista.add(new ModoPreparoVO());

        ModoPreparoFragmentAdapter adapter = new ModoPreparoFragmentAdapter(getContext(), lista);
        binding.modos.setAdapter(adapter);

        binding.additem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lista.add(new ModoPreparoVO());
                adapter.notifyDataSetChanged();
            }
        });
        return view;
    }
}