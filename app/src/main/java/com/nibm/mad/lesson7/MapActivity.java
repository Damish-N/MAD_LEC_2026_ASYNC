package com.nibm.mad.lesson7;

import android.content.Intent;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.nibm.mad.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap mMap ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().
                        findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap  = googleMap;
        LatLng galle = new LatLng( 6.0329,80.2168);
        mMap.addMarker(new MarkerOptions().position(galle).
                icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(galle,10));
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        List<LatLng> polylinePoints = new ArrayList<>();
        polylinePoints.add(new LatLng(6.053519, 80.220978)); // Galle
        polylinePoints.add(new LatLng(6.927079, 79.861244)); // Colombo
        PolylineOptions polylineOptions = new PolylineOptions()
                .addAll(polylinePoints)
                .width(5) // Set the width of the polyline
                .color(Color.RED); // Set the color of the polyline
        mMap.addPolyline(polylineOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(polylinePoints.get(0), 4));

        UiSettings uiSettings = mMap.getUiSettings();
//        uiSettings.setZoomGesturesEnabled(false);

        mMap.setOnCameraMoveListener(
                new GoogleMap.OnCameraMoveListener() {
                    @Override
                    public void onCameraMove() {
                        LatLng latLng= mMap.getCameraPosition().target;
                        Log.d("Move G" ,  latLng.toString());
                    }
                }
        );
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        mMap.setOnMapClickListener(
                latLng -> {
                    mMap.clear();
                    mMap.addMarker(
                           new MarkerOptions().
                                   position(latLng)
                    );
                    try {
                        List<Address> addresses = geocoder.getFromLocation(
                                latLng.latitude, latLng.longitude,1
                        );
                        if (addresses.size()>0){
                            String ad = addresses.get(0).getAddressLine(0);
                            Toast.makeText(this, ad,Toast.LENGTH_SHORT).show();
                        }
                        Uri uri = Uri.parse("google.navigation:q=" + latLng.latitude +
                                "," + latLng.longitude);
                        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                        intent.setPackage("com.google.android.apps.maps");
                        startActivity(intent);

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}