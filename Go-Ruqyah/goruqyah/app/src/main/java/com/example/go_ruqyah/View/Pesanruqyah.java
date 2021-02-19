package com.example.go_ruqyah.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.fragment.app.FragmentActivity;

import com.example.go_ruqyah.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Pesanruqyah extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap gmap;
    private ImageButton pesanbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanruqyah);

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_peruqyah);
        supportMapFragment.getMapAsync(this);

        pesanbtn = findViewById(R.id.pesanbtn);
        pesanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pesanruqyah.this, Checkout.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gmap = googleMap;
        LatLng semarang = new LatLng(-6.966667, 110.416664);
        gmap.addMarker(new MarkerOptions().position(semarang).title("Alamatnya"));
        gmap.moveCamera(CameraUpdateFactory.newLatLng(semarang));
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(semarang, 14);
        gmap.animateCamera(cameraUpdate);

    }
}