package com.yorkdecorsoftware.chefsstation.persistence;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "receita",
foreignKeys = {
})
public class ReceitaVO {

    public ReceitaVO(){

    }

    @PrimaryKey(autoGenerate = true)
    private int rec_uid;

    @ColumnInfo(index = true)
    private String titulo;

    @ColumnInfo(index = true)
    private String descricao;

    @ColumnInfo
    private String tempopreparo;

    @ColumnInfo
    private String rendimento;

    @ColumnInfo
    private String dificuldade;

    @ColumnInfo
    private String pathcapa;

    @Ignore
    private List<IngredienteVO> ingrediente;

//    @ColumnInfo()
//    private List<ModoPreparoVO> modopreparo;
//
//    @ColumnInfo
//    private List<EtiquetaVO> etiqueta;

    public int getRec_uid() {
        return rec_uid;
    }

    public void setRec_uid(int rec_uid) {
        this.rec_uid = rec_uid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTempopreparo() {
        return tempopreparo;
    }

    public void setTempopreparo(String tempopreparo) {
        this.tempopreparo = tempopreparo;
    }

    public String getRendimento() {
        return rendimento;
    }

    public void setRendimento(String rendimento) {
        this.rendimento = rendimento;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getPathcapa() {
        return pathcapa;
    }

    public void setPathcapa(String pathcapa) {
        this.pathcapa = pathcapa;
    }

    public List<IngredienteVO> getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(List<IngredienteVO> ingrediente) {
        this.ingrediente = ingrediente;
    }
}
