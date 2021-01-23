package com.yorkdecorsoftware.chefsstation.ui.ingrediente;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.yorkdecorsoftware.chefsstation.databinding.FragmentIngredientesTabBinding;
import com.yorkdecorsoftware.chefsstation.persistence.IngredienteVO;

import java.util.ArrayList;


public class IngredienteFragment extends Fragment {

    private FragmentIngredientesTabBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentIngredientesTabBinding.inflate(inflater, container, false);
        View view = binding.getRoot();



        ArrayList<IngredienteVO> ingredientes = new ArrayList<>();
        ingredientes.add(new IngredienteVO());
        ingredientes.add(new IngredienteVO());
        ingredientes.add(new IngredienteVO());
        ingredientes.add(new IngredienteVO());

        IngredienteFragmentAdapter adapter = new IngredienteFragmentAdapter(getContext(), ingredientes);
        binding.ingredientes.setAdapter(adapter);

        binding.addingrediente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingredientes.add(new IngredienteVO());
                adapter.notifyDataSetChanged();
            }
        });
        return view;
    }
}