package com.example.lucasnildaimon.govhackapp;

import android.content.res.AssetManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MapaPostosDeSaude extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    //Tela com o mapa dos Postos de Saúde
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
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

        //Focaliza e ajusta o nível de zoom para Cuiabá
        mMap.moveCamera( CameraUpdateFactory.newLatLngZoom(new LatLng(-15.5989,-56.0949) , 12.f));

        try {

            ////Leitura de arquivo texto contendo as coordenadas obtidas através da geocodificação dos endereços fornecidos pelo banco de dados do TCU
            AssetManager assetManager2 = getResources().getAssets();
            InputStream inputStream2 = assetManager2.open("estabelecimentossaude.csv");
            InputStreamReader inputStreamReader2 = new InputStreamReader(inputStream2);
            BufferedReader arq2 = new BufferedReader(inputStreamReader2);
            String linha2 = arq2.readLine();
            String coluna2[];



            while(linha2 != null){

                //Adiciona os marcadores no mapa para cada estabelecimento de saúde a partir de suas coordenadas
                coluna2 = linha2.split(",");

                coluna2 = linha2.split(",");
                 LatLng latlng2 = new LatLng(Double.valueOf(coluna2[0]),Double.valueOf(coluna2[1]));
                mMap.addMarker(new MarkerOptions().position(latlng2).title("Saúde").snippet("Aqui está localizado um estabelecimento de saúde").icon(BitmapDescriptorFactory.fromAsset("saude.png")));

                linha2 = arq2.readLine();


            }

        } catch (Exception e ) {
            e.printStackTrace();
        }
    }
}
