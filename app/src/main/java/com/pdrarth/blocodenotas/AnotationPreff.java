package com.pdrarth.blocodenotas;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotationPreff {


    //eu to criando um contexto de algo
    private Context context;


    //recuperar uma anotacao
    private SharedPreferences preferences;


    //salvar um anotacao
    private SharedPreferences.Editor editor;


    private final String NOME_ARQUIVO = "Anotation";
    private final String CHAVE_NOME = "nome";


    public AnotationPreff(Context c) {
        this.context = c;

        //Aonde esses dados vao ficar salvor, eu tenho que criar isso, como se fosse um banco de dados local
        //passei ele como mode = 0 pois so meu app pode acessar ele
        preferences = context.getSharedPreferences(NOME_ARQUIVO, 0);

        //aqui eu chamo meu editor para ele savar
        editor = preferences.edit();
    }


    //Crinado um metodo para salvar anotacao
    public void SalvarAction(String anotacao) {
        //o putstring eu salvo ele, e preciso passar uma chave novamente para ela
        editor.putString(CHAVE_NOME, anotacao);
        //aqui eh para executar
        editor.commit();
    }


    //Crinado um recuepar e  salvar anotacao
    public String RecuperarAnotation() {
        //aqui eu recupero o que o usuario digitou em salvarAction, passo a chave aonde ele salvo, e retorno um valor vazio
        return preferences.getString(CHAVE_NOME,"");

    }


}
