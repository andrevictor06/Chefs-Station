package com.yorkdecorsoftware.chefsstation.ui.fotocapa;

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

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.yorkdecorsoftware.chefsstation.Mensagem;
import com.yorkdecorsoftware.chefsstation.R;
import com.yorkdecorsoftware.chefsstation.controle.CtrlReceita;
import com.yorkdecorsoftware.chefsstation.databinding.FragmentFotosTabBinding;
import com.yorkdecorsoftware.chefsstation.databinding.FragmentReceitaTabBinding;
import com.yorkdecorsoftware.chefsstation.persistence.ReceitaVO;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class FotoCapaFragment extends Fragment {

    private ReceitaVO receita = new ReceitaVO();
    private FragmentFotosTabBinding binding;
    private CtrlReceita ctrlReceita;

    private Bitmap imagem;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFotosTabBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        ctrlReceita = CtrlReceita.getInstance(getContext());

        binding.upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPictureDialog();
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        fav = menu.add("add");
//        fav.setIcon(R.drawable.btn_star_big_off);
//    }

    private void saveToGallery(){
        BitmapDrawable bitmapDrawable = (BitmapDrawable) binding.capa.getDrawable();
        if(bitmapDrawable != null){

            Bitmap bitmap = bitmapDrawable.getBitmap();

            FileOutputStream outputStream = null;
            File file = Environment.getExternalStorageDirectory();

            //Toast.makeText(getContext(), file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
            File dir = new File(file.getAbsolutePath() + "/ChefsStation");
            dir.mkdirs();

            String filename = String.format("%d.png",System.currentTimeMillis());
            File outFile = new File(dir,filename);
            try{
                outputStream = new FileOutputStream(outFile);
            }catch (Exception e){
                e.printStackTrace();
            }
            bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
            try{
                receita.setPathcapa(outFile.getAbsolutePath());
                outputStream.flush();
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                outputStream.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private final int GALERIA   = 0;
    private final int CAMERA    = 1;
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case GALERIA:

                if (data != null) {
                    Uri contentURI = data.getData();
                    try {
                        imagem = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), contentURI);
                        binding.capa.setImageBitmap(imagem);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            case CAMERA:
                try {
                    if(data != null) {
                        imagem = (Bitmap) data.getExtras().get("data");
                        binding.capa.setImageBitmap(imagem);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            default:
               // Toast.makeText(getContext(), R.string.msm_enviada_erro, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void showPictureDialog(){
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(getContext());
        pictureDialog.setTitle(R.string.escolher_foto);
        String[] pictureDialogItems = {
                getResources().getString(R.string.escolher_foto_galeria),
                getResources().getString(R.string.escolher_foto_camera)};
        pictureDialog.setItems(pictureDialogItems,
                (dialog, which) -> {
                    switch (which) {
                        case GALERIA:
                            choosePhotoFromGallary();
                            break;
                        case CAMERA:
                            takePhotoFromCamera();
                            break;
                    }
                });
        pictureDialog.show();
    }

    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, 0);
    }

    private void takePhotoFromCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);
    }

}