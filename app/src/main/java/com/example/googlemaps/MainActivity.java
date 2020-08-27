package com.example.googlemaps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Map;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {
    GoogleMap Mapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager()
                        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Mapa = googleMap;
        Mapa.setOnMapClickListener(this);

    }
    public void cambiarVista(View view){
        Mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        Mapa.getUiSettings().setZoomControlsEnabled(true);
    }
    public void moverCamara(View view){
        CameraUpdate camUpd1 = CameraUpdateFactory
                        .newLatLngZoom(new LatLng(-1.012592, -79.469445), 17);
        Mapa.moveCamera(camUpd1);
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012952, -79.467718)).title("Auditorio Carlos Cortaza"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012244, -79.469193)).title("Laboratorios UTEQ"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012260, -79.469021)).title("Departamento de Bienestar Estudiantil"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012227, -79.469649)).title("Instituto de Informática"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012351, -79.468431)).title("Biblioteca UTEQ"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012576, -79.470561)).title("FCI"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012156, -79.470116)).title("FCE"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012945, -79.469987)).title("Bar UTEQ"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012889, -79.469389)).title("FCA"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012714, -79.471057)).title("F.C. Ambientales"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.013068, -79.470371)).title("Oficinas"));

    }
    public  void polig (View view){
        PolylineOptions lineas = new PolylineOptions()
                .add(new LatLng(-1.012952, -79.467718))
                .add(new LatLng(-1.012351, -79.468431))
                .add(new LatLng(-1.012260, -79.469021))
                .add(new LatLng(-1.012244, -79.469193))
                .add(new LatLng(-1.012227, -79.469649))
                .add(new LatLng(-1.012156, -79.470116))
                .add(new LatLng(-1.012576, -79.470561))
                .add(new LatLng(-1.012714, -79.471057))
                .add(new LatLng(-1.013068, -79.470371))
                .add(new LatLng(-1.012945, -79.469987))
                .add(new LatLng(-1.012889, -79.469389))
                .add(new LatLng(-1.012952, -79.467718));
        lineas.width(8);
        lineas.color(Color.GREEN);
        Mapa.addPolyline(lineas);
    }

    @Override
    public void onMapClick(LatLng latLng) {


       /* Mapa.addMarker(new MarkerOptions().position(latLng).title("Punto en el Mapa"));

        Projection proj = Mapa.getProjection();
        Point coord = proj.toScreenLocation(latLng);
        Toast.makeText(MainActivity.this,
                "Click\n" +
                        "Lat: " + latLng.latitude + "\n" +
                        "Lng: " + latLng.longitude + "\n" +
                        "X: " + coord.x + " - Y: " + coord.y,
                Toast.LENGTH_LONG).show();*/
    }
}