package com.yorkdecorsoftware.chefsstation.ui.receita;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.yorkdecorsoftware.chefsstation.Mensagem;
import com.yorkdecorsoftware.chefsstation.Utils;
import com.yorkdecorsoftware.chefsstation.controle.CtrlReceita;
import com.yorkdecorsoftware.chefsstation.databinding.FragmentReceitaTabBinding;
import com.yorkdecorsoftware.chefsstation.persistence.ReceitaVO;

import java.util.Random;

public class ReceitaFragmentTab extends Fragment {

    private ReceitaVO receita = new ReceitaVO();
    private FragmentReceitaTabBinding binding;
    private CtrlReceita ctrlReceita;

    private Bitmap imagem;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentReceitaTabBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        ctrlReceita = CtrlReceita.getInstance(getContext());

        if(savedInstanceState != null){
            int rec_uid = savedInstanceState.getInt("rec_uid");
            //receita.setRec_uid(rec_uid);
            receita = ctrlReceita.loadById(rec_uid);
        }

        if(receita != null){
            binding.uid.setText("" + receita.getRec_uid());
            binding.titulo.setText(receita.getTitulo());
            binding.descricao.setText(receita.getDescricao());
            binding.tempopreparo.setText(receita.getTempopreparo());
            binding.rendimento.setText(receita.getRendimento());
            binding.dificuldade.setText(receita.getDificuldade());
        }
//        binding.upload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showPictureDialog();
//            }
//        });

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int random = new Random().nextInt();
                receita = new ReceitaVO();
                if( Utils.validaObjeto(binding.uid.getText().toString()) )
                    receita.setRec_uid( new Integer(binding.uid.getText().toString()));
                receita.setTitulo(binding.titulo.getText().toString());
                receita.setDescricao(binding.descricao.getText().toString());
                receita.setTempopreparo(binding.tempopreparo.getText().toString());
                receita.setRendimento(binding.rendimento.getText().toString());
                receita.setDificuldade(binding.dificuldade.getText().toString());
                //saveToGallery();
                Mensagem msm = null;
                if(receita.getRec_uid() <= 0){
                    msm = ctrlReceita.insertAll(receita);
                }else{
                    msm = ctrlReceita.updateAll(receita);
                }
                if (msm.getFoco() != null){
                    switch (msm.getFoco()){
                        case "titulo":
                            binding.titulo.requestFocusFromTouch();
                        break;

                        default:break;
                    }
                }
                Snackbar.make(view, msm.getMensagem(), Snackbar.LENGTH_LONG).show();
                //Toast.makeText(getContext(), msm.getMensagem(), Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}