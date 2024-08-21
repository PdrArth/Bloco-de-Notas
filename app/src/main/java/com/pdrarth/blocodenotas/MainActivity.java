package com.pdrarth.blocodenotas;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    //chamando minha classe
    private AnotationPreff Preferencias;

    //chamando o edittext do xml
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //chamando ele
        editText = findViewById(R.id.anotation);

        //aqui eu to chamando o botao de salvar
        FloatingActionButton BtSalvar = findViewById(R.id.fb_salvar);


        //eu chamo o getaplication(nome que esta no construtor)
        Preferencias = new AnotationPreff(getApplicationContext());

        BtSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //estou chamando o meu metodo edittext do xml, com isso eu recupero o que foi digitado, e converto para uma string
                String textRecuperar = editText.getText().toString();

                if (textRecuperar.equals("")) {
                    //mensagem
                    Toast.makeText(getApplicationContext(), "Preencha o campo", Toast.LENGTH_SHORT).show();
                }
                else {

                    //aqui eu to chamando meu objeto, e uso o metodo salvar que esta na classe e uso minha variavel de recupera text
                    Preferencias.SalvarAction(textRecuperar);
                    //mensagem
                    Toast.makeText(getApplicationContext(), "Salvo com Sucesso", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Recuperar Anotacaop
        String Anotation = Preferencias.RecuperarAnotation();
        if(Anotation != null){
            editText.setText(Anotation);
        }
    }
}