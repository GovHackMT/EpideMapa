package com.example.lucasnildaimon.govhackapp;

import android.content.res.AssetManager;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;


public class MapaEpidemiologico extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Ajusta o foco e o nível de zoom. Os parâmetros são as coordenadas de Cuiabá
        mMap.moveCamera( CameraUpdateFactory.newLatLngZoom(new LatLng(-15.5989,-56.0949) , 12.f));

        try {
            //Leitura de arquivo texto contendo as coordenadas obtidas através da geocodificação dos endereços fornecidos pela SES no banco de dados das doenças
            //Leitura do bando da dengue
            AssetManager assetManager = getResources().getAssets();
            InputStream inputStream = assetManager.open("DengueCuiaba2015Fatality2.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader arq = new BufferedReader(inputStreamReader);
            String linha = arq.readLine();
            String coluna[];
            // Leitura do banco de tuberculose
            AssetManager assetManager1 = getResources().getAssets();
            InputStream inputStream1 = assetManager1.open("TuberculoseCuiaba2015Fatality2.csv");
            InputStreamReader inputStreamReader1 = new InputStreamReader(inputStream1);
            BufferedReader arq1 = new BufferedReader(inputStreamReader1);
            String linha1 = arq1.readLine();
            String coluna1[];


            while(linha != null){
                coluna = linha.split(",");

                //Adiciona os marcadores no mapa para cada doença a partir de suas coordenadas

                LatLng latlng = new LatLng(Double.valueOf(coluna[0]), Double.valueOf(coluna[1]));
                mMap.addMarker(new MarkerOptions().position(latlng).title("Dengue").snippet("Aqui foi registrado um caso de dengue").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));


                coluna1 = linha1.split(",");
                LatLng latlng1 = new LatLng(Double.valueOf(coluna1[0]),Double.valueOf(coluna1[1]));
                mMap.addMarker(new MarkerOptions().position(latlng1).title("Tuberculose").snippet("Aqui foi registrado um caso de tuberculose").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));


                linha = arq.readLine();
                linha1 = arq1.readLine();


            }

        } catch (Exception e ) {
            e.printStackTrace();
        }




    }
}
