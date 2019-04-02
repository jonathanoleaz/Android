package com.example.mapas;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends AppCompatActivity
        implements OnMapReadyCallback {

    private GoogleMap mMap;

    private Button btnTeot;
    private Button btnMachuPichu;
    private Button btnMuralla;
    private Button btnBigBen;
    private Button btnSydney;
    private Button btnJohanesburgo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

        btnTeot = (Button)findViewById(R.id.btnTeot);
        btnTeot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarMarcador(0);
            }
        });

        btnMachuPichu = (Button)findViewById(R.id.btnMachu);
        btnMachuPichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarMarcador(1);
            }
        });

        btnMuralla = (Button)findViewById(R.id.btnMuralla);
        btnMuralla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarMarcador(2);
            }
        });

        btnBigBen = (Button)findViewById(R.id.btnBigBen);
        btnBigBen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarMarcador(3);
            }
        });

        btnSydney = (Button)findViewById(R.id.btnSydney);
        btnSydney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarMarcador(4);
            }
        });

        btnJohanesburgo = (Button)findViewById(R.id.btnJohan);
        btnJohanesburgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarMarcador(5);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;

        mMap.getUiSettings().setMapToolbarEnabled(false);

    }

    private void insertarMarcador(int punto) {
        System.out.println("insertando punto");
        LatLng sitioTuristico=new LatLng(19, -99);;
        switch (punto){
            case 0:
                sitioTuristico = new LatLng(19, -99);
                break;
            case 1:
                sitioTuristico = new LatLng(-13, -72);
                break;

            case 2:
                sitioTuristico = new LatLng(40.431908, 116.570374);
                break;
            case 3:
                sitioTuristico = new LatLng(51.500729, -0.124625);
                break;

            case 4:
                sitioTuristico = new LatLng(-33.868820, 151.209290);
                break;
            case 5:
                sitioTuristico = new LatLng(-26.201450, 28.045490);
                break;
        }

        mMap.addMarker(new MarkerOptions()
                .position(sitioTuristico)
                .title("Sitio turístico"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sitioTuristico));

    }
}