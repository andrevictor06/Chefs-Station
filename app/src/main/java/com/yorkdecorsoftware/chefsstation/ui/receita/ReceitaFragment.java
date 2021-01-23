package com.yorkdecorsoftware.chefsstation.ui.receita;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.yorkdecorsoftware.chefsstation.Mensagem;
import com.yorkdecorsoftware.chefsstation.R;
import com.yorkdecorsoftware.chefsstation.controle.CtrlReceita;
import com.yorkdecorsoftware.chefsstation.databinding.FragmentReceitaBinding;
import com.yorkdecorsoftware.chefsstation.persistence.IngredienteVO;
import com.yorkdecorsoftware.chefsstation.persistence.ReceitaVO;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class ReceitaFragment extends Fragment {

    private FragmentReceitaBinding binding;
    private TabsReceitaFragmentAdapter adapter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("savedInstanceState 1"  + savedInstanceState);
        binding = FragmentReceitaBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        adapter = new TabsReceitaFragmentAdapter(this, savedInstanceState);
        binding.paginas.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        System.out.println("savedInstanceState 2"  + savedInstanceState);
        TabLayout tabLayout = binding.tabLayout;
        new TabLayoutMediator(tabLayout, binding.paginas,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        if(savedInstanceState != null){
                            Snackbar.make(view, "rec_uid: " + savedInstanceState.get("title"), Snackbar.LENGTH_LONG).show();
                        }
                        TabsReceita tabsReceita = TabsReceita.values()[position];
                        tab.setText(tabsReceita.getTitleResId());
                    }
            }
        ).attach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}