package com.example.lucasnildaimon.govhackapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        Button mapa = (Button) findViewById(R.id.button2);
        // Método para troca de telas
        mapa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(TelaInicial.this, MapaEpidemiologico.class);
                startActivity(it);
            }
        });

        Button dengue = (Button) findViewById(R.id.button3);
        // Método para troca de telas
        dengue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(TelaInicial.this, TelaInfoDengue.class);
                startActivity(it);
            }
        });

        Button tuberculose = (Button) findViewById(R.id.button4);
        // Método para troca de telas
        tuberculose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(TelaInicial.this, TelaInfoTuberculose.class);
                startActivity(it);
            }
        });

        Button saude = (Button) findViewById(R.id.button5);
        // Método para troca de telas
        saude.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(TelaInicial.this, MapaPostosDeSaude.class);
                startActivity(it);
            }
        });

    }

}
