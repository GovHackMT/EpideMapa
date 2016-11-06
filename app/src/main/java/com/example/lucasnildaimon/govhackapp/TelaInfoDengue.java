package com.example.lucasnildaimon.govhackapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class TelaInfoDengue extends AppCompatActivity {

            //Tela de informações sobre a Dengue
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button mapasaude = (Button) findViewById(R.id.button5);

        //Botão que redireciona para o mapa de Postos de Saúde
        mapasaude.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(TelaInfoDengue.this, MapaPostosDeSaude.class);
                startActivity(it);
            }
        });


    }


}
