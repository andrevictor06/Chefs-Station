package com.yorkdecorsoftware.chefsstation;

public class Mensagem {

    private String mensagem;
    private boolean ok;
    private String tipo;
    private String foco;

    public void set(String mensagem, boolean ok, String tipo){
        setMensagem(mensagem);
        setOk(ok);
        setTipo(tipo);
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFoco() {
        return foco;
    }

    public void setFoco(String foco) {
        this.foco = foco;
    }
}
