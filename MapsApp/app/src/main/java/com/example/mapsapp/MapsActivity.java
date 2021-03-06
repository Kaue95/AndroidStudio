package com.example.mapsapp;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;


import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private String[] permissoes = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION
    };
    private LocationManager locationManager;
    private LocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Permissoes.validarpermn(permissoes, this, 1);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);


        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                Log.d("localiza??ao", "onLocationChanged" + location.toString());

                Double latitude = location.getLatitude();
                Double longitude = location.getLongitude();

                mMap.clear();

                Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                try {
                    //Recupera o endere??o do usu??rio
                    List< Address > listaEndereco = geocoder.getFromLocation(latitude, longitude, 1);

                    //Recuperar o local pelo endere??o
                    String enderecoLocal = "Av. Feliciano Correia, s/n - Jardim Satelite, S??o Paulo - SP, 04815-240";
                    //List<Address> listaEndereco = geocoder.getFromLocationName(enderecoLocal, 1);

                    //testando se realmente temos um endere??o
                    if (listaEndereco != null && listaEndereco.size() > 0) {
                        //se quiser utilizar uma estrutura de repeti????o pode pegar a lista de endere??o toda
                        Address endereco = listaEndereco.get(0);
                        //Log.d("local", "onLocationChanged: " + endereco.getAddressLine(0));

                        //Posicionando o marcador com base no endere??o do usu??rio

                        Double lat = endereco.getLatitude();
                        Double lon = endereco.getLongitude();
                        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                        //Criando marcador com o endere??o do usu??rio
                        LatLng localUsuario = new LatLng(lat, lon);

                        mMap.addMarker(new MarkerOptions()
                                .position(localUsuario)
                                .title("Local atual")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.lpoint))
                        );
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(localUsuario, 15));

                        /*
                         * D/local: onLocationChanged:
                         * Address[addressLines=[0:"R. Bonsucesso, 60 - Jardim Noronha, S??o Paulo - SP, 04853-192, Brazil"],
                         * feature=60,
                         * admin=S??o Paulo,
                         * sub-admin=S??o Paulo,
                         * locality=null,
                         * thoroughfare=Rua Bonsucesso,
                         * postalCode=04853-192,
                         * countryCode=BR,
                         * countryName=Brazil,
                         * hasLatitude=true,
                         * latitude=-23.7716203,
                         * hasLongitude=true,
                         * longitude=-46.6768499,
                         * phone=null,
                         * url=null,
                         * extras=null]

                         * */


                        Log.d("local", "onLocationChanged: " + endereco.toString());
                        //txtNomeEndereco.setText(endereco.getAddressLine(0));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    locationManager.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            1000, 10,
                            locationListener
                    );

                    
            }

        };

    }
}