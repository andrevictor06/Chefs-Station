package com.yorkdecorsoftware.chefsstation;

public class Utils {

    public static boolean validaObjeto(Object item){
        if( item == null)
            return false;
        if(item instanceof  String)
            return  ! ((String)item).isEmpty();

        return true;
    }

    public static String completarString(Object item, int tamanho, String complemento) {
        if( validaObjeto(item)){
            String resultado = "";
            if(item instanceof Integer){
                resultado = String.valueOf((Integer) item);
            }
            if(item instanceof String){
                resultado = ((String) item);
            }

            if(resultado.length() < tamanho){
                for (int i = 0; i < (tamanho - resultado.length() + 1); i++) {
                    resultado = complemento + resultado;
                    System.out.println("resultado.length()" + resultado +  " complemento  " + complemento);
                }
            }

            return resultado;
        }
        return "";
    }
}
