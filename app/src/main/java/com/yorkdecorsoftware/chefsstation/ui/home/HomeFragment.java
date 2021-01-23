package com.yorkdecorsoftware.chefsstation.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.google.android.material.snackbar.Snackbar;
import com.yorkdecorsoftware.chefsstation.R;
import com.yorkdecorsoftware.chefsstation.controle.CtrlReceita;
import com.yorkdecorsoftware.chefsstation.databinding.FragmentHomeBinding;
import com.yorkdecorsoftware.chefsstation.persistence.ReceitaVO;
import com.yorkdecorsoftware.chefsstation.ui.receita.ReceitaFragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ReceitaVO receita = new ReceitaVO();
    private FragmentHomeBinding binding;

    private CtrlReceita ctrlReceita;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.listItem.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position,long arg3) {
                        ReceitaVO item = (ReceitaVO) binding.listItem.getItemAtPosition(position);
                        Bundle extra = savedInstanceState;
                        if (extra == null) {
                            extra = new Bundle();
                        }
//                        getContext().getSupportFragmentManager().beginTransaction()
//                                .setReorderingAllowed(true)
//                                .add(R.layout.fragment_receita_tab, ReceitaFragment.class, null)
//                                .commit();
                        if (extra != null) {
                            extra.putInt("rec_uid", item.getRec_uid());
                        }
                        System.out.println("savedInstanceState "  + extra);
                        Fragment fr = new ReceitaFragment();
                        fr.setArguments(extra);

                        FragmentManager fm = getFragmentManager();
                        fm.beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.nav_host_fragment, fr)
                        .commit();


                        //Snackbar.make(view, item.getRec_uid() + " - " + item.getTitulo(), Snackbar.LENGTH_LONG).show();
                        //Toast.makeText(getContext(), item.getUid() + " - " + item.getTitulo(), Toast.LENGTH_LONG).show();
                    }
                });

        listAll(view);

        return view;
    }

    private void listAll(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                ctrlReceita = CtrlReceita.getInstance(getContext());
                // Construct the data source
                ArrayList<ReceitaVO> lista = null;
                try {
                     lista = (ArrayList<ReceitaVO>) ctrlReceita.getAll();
                }catch (Exception e){
                    e.printStackTrace();
                    Snackbar.make(view, e.getMessage(), Snackbar.LENGTH_LONG).show();
                    lista = new ArrayList<>();
                }

                // Create the adapter to convert the array to views
                HomeFragmentAdapter adapter = new HomeFragmentAdapter(getContext(), lista);
                binding.listItem.setAdapter(adapter);
            }
        }).start();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Add your menu entries here
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}