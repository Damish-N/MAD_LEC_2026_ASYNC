package com.nibm.mad.lesson7;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Task;
import com.nibm.mad.R;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapCurrentLocation extends FragmentActivity implements OnMapReadyCallback {
    Location currentLoction;
    FusedLocationProviderClient fusedLocationProviderClient;
    GoogleMap mMap;
    private static final int FINE_PERMISSION_CODE = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_map);
        fusedLocationProviderClient = LocationServices.
                getFusedLocationProviderClient(this);
        getLastLocation();
    }

    private void getLastLocation(){
        if (ActivityCompat.
                checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    FINE_PERMISSION_CODE);

            return;
        }

        Task<Location> task = fusedLocationProviderClient.
                getLastLocation();
        task.addOnSuccessListener(
                location -> {
                    if (location !=null){
                        currentLoction = location;
                        SupportMapFragment mapFragment =
                                (SupportMapFragment) getSupportFragmentManager().
                                        findFragmentById(R.id.map);
                        mapFragment.getMapAsync(this);
                    }
                });
    }
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        LatLng galle = new LatLng( currentLoction.getLatitude(),currentLoction.getLongitude());

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(
                    currentLoction.getLatitude(), currentLoction.getLongitude(),1
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (addresses.size()>0){
            String ad = addresses.get(0).getAddressLine(0);
            Toast.makeText(this, ad,Toast.LENGTH_SHORT).show();
        }
         mMap.addMarker(new MarkerOptions().position(galle).
                icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(galle,10));
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
