package com.yorkdecorsoftware.chefsstation.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;

import com.google.android.material.snackbar.Snackbar;
import com.yorkdecorsoftware.chefsstation.MainActivity;
import com.yorkdecorsoftware.chefsstation.R;
import com.yorkdecorsoftware.chefsstation.Utils;

import com.yorkdecorsoftware.chefsstation.databinding.FragmentHomeItemBinding;
import com.yorkdecorsoftware.chefsstation.persistence.ReceitaVO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class HomeFragmentAdapter extends ArrayAdapter<ReceitaVO> {

    private FragmentHomeItemBinding binding;
    public HomeFragmentAdapter(Context context, ArrayList<ReceitaVO> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home_item, parent, false);
        }

        binding = FragmentHomeItemBinding.inflate(LayoutInflater.from(getContext()), parent, false);
        View view = binding.getRoot();
        // Get the data item for this position
        ReceitaVO user = getItem(position);

        String url = "";
        if(Utils.validaObjeto(user.getPathcapa())){
            url = user.getPathcapa();
            File imagem = new File(user.getPathcapa());
            if(imagem.exists()){
                Bitmap myBitmap = BitmapFactory.decodeFile(imagem.getAbsolutePath());
                binding.pathcapa.setImageBitmap(myBitmap);
            }else{
              //  binding.pathcapa.setVisibility(View.GONE);
            }
        }else{
           // binding.pathcapa.setVisibility(View.GONE);
        }

        binding.titulo.setText(user.getTitulo());

        binding.tempopreparo.setText(user.getTempopreparo());
        //binding.tempopreparo.setVisibility( Utils.validaObjeto(user.getTempopreparo()) ? View.VISIBLE : View.GONE );

        binding.rendimento.setText(user.getRendimento());
        //binding.rendimento.setVisibility( Utils.validaObjeto(user.getRendimento()) ? View.VISIBLE : View.GONE );

        binding.dificuldade.setText(user.getDificuldade());
        //binding.dificuldade.setVisibility( Utils.validaObjeto(user.getDificuldade()) ? View.VISIBLE : View.GONE );

        binding.descricao.setText(user.getDescricao());
        //binding.descricao.setVisibility( Utils.validaObjeto(user.getDescricao()) ? View.VISIBLE : View.GONE );
        // Return the completed view to render on screen

        binding.menureceita.inflateMenu(R.menu.menu_lista_receitas);
        binding.menureceita.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()){
                    case R.id.compartilharpdf:
                        try {
                            gerarpdf();

                            File file = Environment.getExternalStorageDirectory();
                            File dir = new File(file.getAbsolutePath() + "/ChefsStation/PDF");
                            dir.mkdirs();

                            String filename = "pdf_gerado.pdf";
                            File outFile = new File(dir,filename);

                            if(outFile.exists()){
                                Intent sendIntent = new Intent();
                                sendIntent.setAction(Intent.ACTION_DEFAULT);
                                sendIntent.addCategory(Intent.CATEGORY_DEFAULT);
                                sendIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

                                Uri fileUri = FileProvider.getUriForFile( getContext(), "com.yorkdecorsoftware.chefsstation.fileprovider", outFile);
                                sendIntent.setDataAndType(fileUri, getContext().getContentResolver().getType(fileUri));

                                System.out.println("AEEEEE " + getContext().getContentResolver().getType(fileUri));
                                Intent shareIntent = Intent.createChooser(sendIntent, null);
                                getContext().startActivity(shareIntent);
                            }else{
                                Snackbar.make(view, "Arquivo nao encontrado!", Snackbar.LENGTH_LONG).show();
                            }


                            //Snackbar.make(view, user.getTitulo() +  " - Compartilhar o PDF", Snackbar.LENGTH_LONG).show();
                        } catch (Exception e) {

                            Snackbar.make(view, e.getMessage(), Snackbar.LENGTH_LONG).show();
                            e.printStackTrace();
                        }
                        //
                        return true;
                    default:
                        break;
                }
                return false;
            }
        });


        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void gerarpdf() throws IOException {
        // create a new document
        PdfDocument document = new PdfDocument();

        // create a page description
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(300, 300, 5).create();

        // start a page
        PdfDocument.Page page = document.startPage(pageInfo);

        // draw something on the page
        View content = binding.getRoot();
        content.draw(page.getCanvas());

        // finish the page
        document.finishPage(page);
        // add more pages
        // write the document content
        document.writeTo(getOutputStream());

        // close the document
        document.close();
        //PDFWriter writer = new PDFWriter(PaperSize.FOLIO_WIDTH, PaperSize.FOLIO_HEIGHT);
    }

    private FileOutputStream getOutputStream() {

        FileOutputStream outputStream = null;
        File file = Environment.getExternalStorageDirectory();

        //Toast.makeText(getContext(), file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        File dir = new File(file.getAbsolutePath() + "/ChefsStation/PDF");
        dir.mkdirs();

        String filename = "pdf_gerado.pdf";
        File outFile = new File(dir,filename);
        try {
            outputStream = new FileOutputStream(outFile);
        }catch (Exception e ){

        }
        return outputStream;
    }
}
