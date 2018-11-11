package com.example.syz_7.parqueoscz;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.tasks.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.syz_7.parqueoscz.models.PlaceInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.OnConnectionFailedListener, GoogleMap.OnInfoWindowClickListener{

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


    public Location locationruta;
    public int brd=0;
    public int brd1=0;
    public int brd2=0;
    public int brd3=0;
    public int brd4=0;
    public int brd5=0;
    public int brd6=0;
    public int brd7=0;
    public int brd8=0;
    public int brd9=0;
    public int brd10=0;

    @Override
    public void onInfoWindowClick(Marker marker) {
        InfoWindowData infoWindowData = (InfoWindowData) marker.getTag();

        if( infoWindowData.getTelefono() == "70996680") {//1

            LatLng destino = new LatLng(-17.772722, -63.185993);
            MarkerOptions marcadorDestino = new MarkerOptions();
            marcadorDestino.position(destino);
            marcadorDestino.title("Este es tu destino");
            //setLocation(location);
            //mMap.addMarker(marcadorDestino);
            Location locruta = locationruta;
            locationMap.put("lat", locruta.getLatitude());
            locationMap.put("lon", locruta.getLongitude());
            LatLng actualLocation = new LatLng(locationMap.get("lat"), locationMap.get("lon"));

            String url = obtenerDireccionesURL(actualLocation, destino);
            DownloadTask downloadTask = new DownloadTask();
            downloadTask.execute(url);
            //marker.remove();
            marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.metas));
            //mMap.addMarker(new MarkerOptions().position(actualLocation).title("Estas aqui").icon(BitmapDescriptorFactory.fromResource(R.drawable.car)));

            if (brd1==0) {
                brd1 = 1;
                brd = 1;
            }else{
                brd1 = 0;
                brd = 0;
            }


            //marcadorDestino.icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("ic_marcador_destino",80,80)));
            //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mLocationListener
        }
        if( infoWindowData.getTelefono() == "70887996") {//2

            LatLng destino = new LatLng(-17.773787, -63.183154);
            MarkerOptions marcadorDestino = new MarkerOptions();
            marcadorDestino.position(destino);
            marcadorDestino.title("Este es tu destino");
            //setLocation(location);
            //mMap.addMarker(marcadorDestino);
            Location locruta = locationruta;
            locationMap.put("lat", locruta.getLatitude());
            locationMap.put("lon", locruta.getLongitude());
            LatLng actualLocation = new LatLng(locationMap.get("lat"), locationMap.get("lon"));

            String url = obtenerDireccionesURL(actualLocation, destino);
            DownloadTask downloadTask = new DownloadTask();
            downloadTask.execute(url);

            marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.metas));
            if (brd2==0) {
                brd2 = 1;
                brd = 1;
            }else{
                brd2 = 0;
                brd = 0;
            }
            //marcadorDestino.icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("ic_marcador_destino",80,80)));
            //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mLocationListener
        }
        if( infoWindowData.getTelefono() == "71076564") {//3

            LatLng destino = new LatLng(-17.771966, -63.183407);
            MarkerOptions marcadorDestino = new MarkerOptions();
            marcadorDestino.position(destino);
            marcadorDestino.title("Este es tu destino");
            //setLocation(location);
            //mMap.addMarker(marcadorDestino);
            Location locruta = locationruta;
            locationMap.put("lat", locruta.getLatitude());
            locationMap.put("lon", locruta.getLongitude());
            LatLng actualLocation = new LatLng(locationMap.get("lat"), locationMap.get("lon"));

            String url = obtenerDireccionesURL(actualLocation, destino);
            DownloadTask downloadTask = new DownloadTask();
            downloadTask.execute(url);

            marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.metas));
            if (brd3==0) {
                brd3 = 1;
                brd = 1;
            }else{
                brd3 = 0;
                brd = 0;
            }
            //marcadorDestino.icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("ic_marcador_destino",80,80)));
            //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mLocationListener
        }
        if( infoWindowData.getTelefono() == "3331234") {//4

            LatLng destino = new LatLng(-17.771651, -63.184248);
            MarkerOptions marcadorDestino = new MarkerOptions();
            marcadorDestino.position(destino);
            marcadorDestino.title("Este es tu destino");
            //setLocation(location);
            //mMap.addMarker(marcadorDestino);
            Location locruta = locationruta;
            locationMap.put("lat", locruta.getLatitude());
            locationMap.put("lon", locruta.getLongitude());
            LatLng actualLocation = new LatLng(locationMap.get("lat"), locationMap.get("lon"));

            String url = obtenerDireccionesURL(actualLocation, destino);
            DownloadTask downloadTask = new DownloadTask();
            downloadTask.execute(url);

            marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.metas));
            if (brd4==0) {
                brd4 = 1;
                brd = 1;
            }else{
                brd4 = 0;
                brd = 0;
            }
            //marcadorDestino.icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("ic_marcador_destino",80,80)));
            //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mLocationListener
        }
        if( infoWindowData.getTelefono() == "3324936") {//5

            LatLng destino = new LatLng(-17.77292, -63.188937);
            MarkerOptions marcadorDestino = new MarkerOptions();
            marcadorDestino.position(destino);
            marcadorDestino.title("Este es tu destino");
            //setLocation(location);
            //mMap.addMarker(marcadorDestino);
            Location locruta = locationruta;
            locationMap.put("lat", locruta.getLatitude());
            locationMap.put("lon", locruta.getLongitude());
            LatLng actualLocation = new LatLng(locationMap.get("lat"), locationMap.get("lon"));

            String url = obtenerDireccionesURL(actualLocation, destino);
            DownloadTask downloadTask = new DownloadTask();
            downloadTask.execute(url);

            marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.metas));
            if (brd5==0) {
                brd5 = 1;
                brd = 1;
            }else{
                brd5 = 0;
                brd = 0;
            }
            //marcadorDestino.icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("ic_marcador_destino",80,80)));
            //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mLocationListener
        }
        if( infoWindowData.getTelefono() == "3201798") {//6

            LatLng destino = new LatLng(-17.773208, -63.188342);
            MarkerOptions marcadorDestino = new MarkerOptions();
            marcadorDestino.position(destino);
            marcadorDestino.title("Este es tu destino");
            //setLocation(location);
            //mMap.addMarker(marcadorDestino);
            Location locruta = locationruta;
            locationMap.put("lat", locruta.getLatitude());
            locationMap.put("lon", locruta.getLongitude());
            LatLng actualLocation = new LatLng(locationMap.get("lat"), locationMap.get("lon"));

            String url = obtenerDireccionesURL(actualLocation, destino);
            DownloadTask downloadTask = new DownloadTask();
            downloadTask.execute(url);

            marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.metas));
            if (brd6==0) {
                brd6 = 1;
                brd = 1;
            }else{
                brd6 = 0;
                brd = 0;
            }
            //marcadorDestino.icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("ic_marcador_destino",80,80)));
            //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mLocationListener
        }
        if( infoWindowData.getTelefono() == "3454236") {//7

            LatLng destino = new LatLng(-17.771492, -63.186136);
            MarkerOptions marcadorDestino = new MarkerOptions();
            marcadorDestino.position(destino);
            marcadorDestino.title("Este es tu destino");
            //setLocation(location);
            //mMap.addMarker(marcadorDestino);
            Location locruta = locationruta;
            locationMap.put("lat", locruta.getLatitude());
            locationMap.put("lon", locruta.getLongitude());
            LatLng actualLocation = new LatLng(locationMap.get("lat"), locationMap.get("lon"));

            String url = obtenerDireccionesURL(actualLocation, destino);
            DownloadTask downloadTask = new DownloadTask();
            downloadTask.execute(url);

            marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.metas));
            if (brd7==0) {
                brd7 = 1;
                brd = 1;
            }else{
                brd7 = 0;
                brd = 0;
            }
            //marcadorDestino.icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("ic_marcador_destino",80,80)));
            //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mLocationListener
        }
        if( infoWindowData.getTelefono() == "3754454") {//8

            LatLng destino = new LatLng(-17.772156, -63.188139);
            MarkerOptions marcadorDestino = new MarkerOptions();
            marcadorDestino.position(destino);
            marcadorDestino.title("Este es tu destino");
            //setLocation(location);
            //mMap.addMarker(marcadorDestino);
            Location locruta = locationruta;
            locationMap.put("lat", locruta.getLatitude());
            locationMap.put("lon", locruta.getLongitude());
            LatLng actualLocation = new LatLng(locationMap.get("lat"), locationMap.get("lon"));

            String url = obtenerDireccionesURL(actualLocation, destino);
            DownloadTask downloadTask = new DownloadTask();
            downloadTask.execute(url);

            marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.metas));
            if (brd8==0) {
                brd8 = 1;
                brd = 1;
            }else{
                brd8 = 0;
                brd = 0;
            }
            //marcadorDestino.icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("ic_marcador_destino",80,80)));
            //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mLocationListener
        }
        if( infoWindowData.getTelefono() == "3456455") {//9

            LatLng destino = new LatLng(-17.770729, -63.183082);
            MarkerOptions marcadorDestino = new MarkerOptions();
            marcadorDestino.position(destino);
            marcadorDestino.title("Este es tu destino");
            //setLocation(location);
            //mMap.addMarker(marcadorDestino);
            Location locruta = locationruta;
            locationMap.put("lat", locruta.getLatitude());
            locationMap.put("lon", locruta.getLongitude());
            LatLng actualLocation = new LatLng(locationMap.get("lat"), locationMap.get("lon"));

            String url = obtenerDireccionesURL(actualLocation, destino);
            DownloadTask downloadTask = new DownloadTask();
            downloadTask.execute(url);

            marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.metas));
            if (brd9==0) {
                brd9 = 1;
                brd = 1;
            }else{
                brd9 = 0;
                brd = 0;
            }
            //marcadorDestino.icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("ic_marcador_destino",80,80)));
            //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mLocationListener
        }
        if( infoWindowData.getTelefono() == "3676575") {//10

            LatLng destino = new LatLng(-17.772055, -63.187925);
            MarkerOptions marcadorDestino = new MarkerOptions();
            marcadorDestino.position(destino);
            marcadorDestino.title("Este es tu destino");
            //setLocation(location);
            //mMap.addMarker(marcadorDestino);
            Location locruta = locationruta;
            locationMap.put("lat", locruta.getLatitude());
            locationMap.put("lon", locruta.getLongitude());
            LatLng actualLocation = new LatLng(locationMap.get("lat"), locationMap.get("lon"));

            String url = obtenerDireccionesURL(actualLocation, destino);
            DownloadTask downloadTask = new DownloadTask();
            downloadTask.execute(url);

            marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.metas));
            if (brd10==0) {
                brd10 = 1;
                brd = 1;
            }else{
                brd10 = 0;
                brd = 0;
            }
            //marcadorDestino.icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("ic_marcador_destino",80,80)));
            //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mLocationListener
        }

    }

    public TextView telf;

    private GoogleMap mMap;
    private GoogleMap mMapruta;
    private HashMap<String, Double> locationMap = new HashMap<>();
    LocationManager locationManager;

    private Marker mMarker;
    //EditText mSearchText; //para el buscador
    private static final String TAG = "MapActivity";
    private static final float DEFAULT_ZOOM = 16f;
    private PlaceInfo mPlace;
    private static final int PLACE_PICKER_REQUEST = 1;
    private static final LatLngBounds LAT_LNG_BOUNDS = new LatLngBounds(
            new LatLng(-40, -168), new LatLng(71, 136));


    private AutoCompleteTextView mSearchText;
    private ImageView mGps, mInfo, mPlacePicker;
    public Button bRuta;

    private String direccion;
    private List<Address> address;
    double longitudeGPS, latitudeGPS;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private PlaceAutocompleteAdapter mPlaceAutocompleteAdapter;
    private GoogleApiClient mGoogleApiClient;

    public LatLng anteriorLocation;



    private final LocationListener mLocationListener = new LocationListener() {

        @Override
        public void onLocationChanged(Location location) {
            locationMap.put("lat", location.getLatitude());
            locationMap.put("lon", location.getLongitude());
        }




        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {
            System.out.println(s);
        }

        @Override
        public void onProviderEnabled(String s) {
            System.out.println(s);
        }

        @Override
        public void onProviderDisabled(String s) {
            System.out.println(s);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settingUpLocation();
        setContentView(R.layout.activity_maps);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        mSearchText = (AutoCompleteTextView) findViewById(R.id.input_search); //EditText para el buscador

        //mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        ////////////////////////////////////////////clic ruta///////////////////////////////////////////



    }

    private void getDeviceLocation() {
        Log.d(TAG, "getDeviceLocation: getting the devices current location");

        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            final Task location = mFusedLocationProviderClient.getLastLocation();
            location.addOnCompleteListener(new OnCompleteListener() {
                @Override
                public void onComplete(@NonNull Task task) {
                    if(task.isSuccessful()){
                        Log.d(TAG, "onComplete: found location!");
                        Location currentLocation = (Location) task.getResult();

                        moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()),
                                DEFAULT_ZOOM,
                                "My Location");

                    }else{
                        Log.d(TAG, "onComplete: current location is null");
                        Toast.makeText(MapsActivity.this, "unable to get current location", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            return;
        }


    }

    private void initMap(){
        Log.d(TAG, "initMap: initializing map");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(MapsActivity.this);
    }

    private void settingUpLocation() {

        locationMap.put("lat", 0.0);
        locationMap.put("lon", 0.0);
    }

    /*mFusedLocationClient.getLastLocation()
        .addOnSuccessListener(this, new OnSuccessListener<Location>() {
        @Override
        public void onSuccess(Location location) {
            // Got last known location. In some rare situations this can be null.
            if (location != null) {
                // Logic to handle location object
            }
        }
    }); */

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
        Toast.makeText(this, R.string.mapa_ready, Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onMapReady: map is ready");
        mMap = googleMap;
        mMap.setMyLocationEnabled(true);
        //LatLng YO= getLastLocation();
        //LatLng YO= locationMap.getClass();
        //LatLng YO= ;
        // Add a marker in Sydney and move the camera
        //getDeviceLocation();
        //init();(-17.772722, -63.185993);


        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mLocationListener);
        Location location = locationManager.getLastKnownLocation(
                locationManager.GPS_PROVIDER);

        if (location != null){

            //init();
            setLocation(location);

        }else{

        }
        locationruta = location;
        LatLng sydney = new LatLng(-17.783313, -63.182051);


        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,16));

        dibujar(1);
        dibujar(2);
        dibujar(3);
        dibujar(4);
        dibujar(5);
        dibujar(6);
        dibujar(7);
        dibujar(8);
        dibujar(9);
        dibujar(10);

        mMap.setOnInfoWindowClickListener(this);

        //Crear rutas



        //mMap.addMarker(new MarkerOptions().position(SN1).title("Nombre: SN \r\n Direccion: '\n'Telefono: --- '\n'Capacidad: 30'\n'Costo: 10bs medio dia'\n'Horario: Lunes - Sabado 7:30 - 19:30").snippet("Nombre: SN" + '\n' + "Direccion: Telefono: --- Capacidad: 30 Costo: 10bs medio dia Horario: Lunes - Sabado 7:30 - 19:30").icon(BitmapDescriptorFactory.fromResource(R.drawable.publico_dd)));
        //mMap.addMarker(new MarkerOptions().position(SN2).title("Nombre: SN '\n'Direccion: '\n'Telefono: --- '\n'Capacidad: 22'\n'Costo: 15bs medio dia'\n'Horario: Lunes - Sabado 8:00 - 20:00").icon(BitmapDescriptorFactory.fromResource(R.drawable.publico_dd)));
        //mMap.addMarker(new MarkerOptions().position(SN3).title("Nombre: SN '\n'Direccion: '\n'Telefono: --- '\n'Capacidad: 16'\n'Costo: 15bs medio dia'\n'Horario: Lunes - Sabado 7:30 - 19:30").icon(BitmapDescriptorFactory.fromResource(R.drawable.publico_oo)));
        //mMap.addMarker(new MarkerOptions().position(Hotel).title("Nombre: Hotel Cortez '\n'Direccion: '\n'Telefono: --- '\n'Capacidad: ---'\n'Costo: ---'\n'Horario: ---").icon(BitmapDescriptorFactory.fromResource(R.drawable.exclusivo_ee)));
        //mMap.addMarker(new MarkerOptions().position(Cre).title("Nombre: Cre '\n'Direccion: '\n'Telefono: --- '\n'Capacidad: ---'\n'Costo: ---'\n'Horario: ---").icon(BitmapDescriptorFactory.fromResource(R.drawable.exclusivo_ee)));
        //mMap.addMarker(new MarkerOptions().position(Multi).title("Nombre: Multi Empresas '\n'Direccion: '\n'Telefono: --- '\n'Capacidad: ---'\n'Costo: ---'\n'Horario: ---").icon(BitmapDescriptorFactory.fromResource(R.drawable.exclusivo_ee)));
        //mMap.addMarker(new MarkerOptions().position(Condominio).title("Nombre: Condominio La Casona '\n'Direccion: '\n'Telefono: --- '\n'Capacidad: ---'\n'Costo: ---'\n'Horario: ---").icon(BitmapDescriptorFactory.fromResource(R.drawable.exclusivo_ee)));


        //mMap.addMarker(new MarkerOptions().position(Condominio).title("Nombre: Condominio La Casona '\n'Direccion: '\n'Telefono: --- '\n'Capacidad: ---'\n'Costo: ---'\n'Horario: ---").icon(BitmapDescriptorFactory.fromResource(R.drawable.exclusivo_ee)));
        //myGoogleMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(LayoutInflater.from(getActivity())));


        //m.showInfoWindow();


    }

    private String obtenerDireccionesURL(LatLng origin,LatLng dest){

        String str_origin = "origin="+origin.latitude+","+origin.longitude;

        String str_dest = "destination="+dest.latitude+","+dest.longitude;

        String sensor = "sensor=false";

        String parameters = str_origin+"&"+str_dest+"&"+sensor;

        String output = "json";

        String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters;

        return url;
    }

    private class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... url) {

            String data = "";

            try{
                data = downloadUrl(url[0]);
            }catch(Exception e){
                Log.d("ERROR AL OBTENER",e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();

            parserTask.execute(result);
        }
    }

    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String,String>>> >{

        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try{
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();

                routes = parser.parse(jObject);
            }catch(Exception e){
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;
            MarkerOptions markerOptions = new MarkerOptions();

            for(int i=0;i<result.size();i++){
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();

                List<HashMap<String, String>> path = result.get(i);

                for(int j=0;j<path.size();j++){
                    HashMap<String,String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                lineOptions.addAll(points);
                lineOptions.width(4);
                if (brd == 1) {
                    lineOptions.color(Color.rgb(0, 0, 255));
                }else
                {
                    lineOptions.color(Color.rgb(0, 0, 0));
                }
            }
            if(lineOptions!=null) {
                mMap.addPolyline(lineOptions);
            }
        }
    }

    public class DirectionsJSONParser {

        public List<List<HashMap<String,String>>> parse(JSONObject jObject){

            List<List<HashMap<String, String>>> routes = new ArrayList<List<HashMap<String,String>>>() ;
            JSONArray jRoutes = null;
            JSONArray jLegs = null;
            JSONArray jSteps = null;

            try {

                jRoutes = jObject.getJSONArray("routes");

                for(int i=0;i<jRoutes.length();i++){
                    jLegs = ( (JSONObject)jRoutes.get(i)).getJSONArray("legs");
                    List path = new ArrayList<HashMap<String, String>>();

                    for(int j=0;j<jLegs.length();j++){
                        jSteps = ( (JSONObject)jLegs.get(j)).getJSONArray("steps");

                        for(int k=0;k<jSteps.length();k++){
                            String polyline = "";
                            polyline = (String)((JSONObject)((JSONObject)jSteps.get(k)).get("polyline")).get("points");
                            List<LatLng> list = decodePoly(polyline);

                            for(int l=0;l<list.size();l++){
                                HashMap<String, String> hm = new HashMap<String, String>();
                                hm.put("lat", Double.toString(((LatLng)list.get(l)).latitude) );
                                hm.put("lng", Double.toString(((LatLng)list.get(l)).longitude) );
                                path.add(hm);
                            }
                        }
                        routes.add(path);
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }catch (Exception e){
            }

            return routes;
        }

        private List<LatLng> decodePoly(String encoded) {

            List<LatLng> poly = new ArrayList<LatLng>();
            int index = 0, len = encoded.length();
            int lat = 0, lng = 0;

            while (index < len) {
                int b, shift = 0, result = 0;
                do {
                    b = encoded.charAt(index++) - 63;
                    result |= (b & 0x1f) << shift;
                    shift += 5;
                } while (b >= 0x20);
                int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
                lat += dlat;

                shift = 0;
                result = 0;
                do {
                    b = encoded.charAt(index++) - 63;
                    result |= (b & 0x1f) << shift;
                    shift += 5;
                } while (b >= 0x20);
                int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
                lng += dlng;

                LatLng p = new LatLng((((double) lat / 1E5)),
                        (((double) lng / 1E5)));
                poly.add(p);
            }

            return poly;
        }
    }

    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try{
            URL url = new URL(strUrl);

            // Creamos una conexion http
            urlConnection = (HttpURLConnection) url.openConnection();

            // Conectamos
            urlConnection.connect();

            // Leemos desde URL
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while( ( line = br.readLine()) != null){
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        }catch(Exception e){
            Log.d("Exception", e.toString());
        }finally{
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }


    //1	SN	Cañada Strongest entre Libertad y Platanillos detrás del condomio la casona	SIN	30	Lunes - Sabado 7:30 - 19:30	10bs medio dia	-17.772569	-63.185951	Privado
    //2	SN	Al frente de la plaza del estudiante calle D'Orbigni	SIN	22	Lunes - Sabado 8:00 - 20:00	15bs medio dia	-17.773648	-63.183303	Privado
    //3	SN	Calle Santa Fe entre Av. Monseñor Rivero y Libertad	SIN	16	Lunes - Sabado 7:30 - 19:30	15bs medio dia	-17.771938	-63.183427	Privado
    //4	Hotel Cortez	Av. Cristóbal de Mendoza entre Av. Monseñor Rivero y Libertad	SIN				-17.771675	-63.184319	Privado exclusivo
    //5	Cre	Calle Honduras entre Av. Cristóbal de Mendoza y Av. Busch	SIN				-17.772968	-63.188996	Privado exclusivo
    //6	Multi Empresas	Calle Fortín Toledo entre Av. Cristóbal de Mendoza y Av. Busch	SIN				-17.773208	-63.188342	Privado exclusivo
    //7	Condominio La Casona	Av. Cristóbal de Mendoza entre Platanillos y Libertad	SIN				-17.771492	-63.186136	Privado exclusivo

    //private void setLoca

    private void setLocation(Location location) {
        locationMap.put("lat", location.getLatitude());
        locationMap.put("lon", location.getLongitude());
        LatLng actualLocation = new LatLng(locationMap.get("lat"), locationMap.get("lon"));

        //anteriorLocation = new LatLng(locationMap.get("lat"), locationMap.get("lon"));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(actualLocation, 16)
        );
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(location.getLatitude(), location.getLongitude()))      // Sets the center of the map to location user
                .zoom(16)                   // Sets the zoom
                .bearing(90)                // Sets the orientation of the camera to east
                .tilt(40)                   // Sets the tilt of the camera to 30 degrees
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mMap.addMarker(new MarkerOptions().position(actualLocation).title("Estas aqui").icon(BitmapDescriptorFactory.fromResource(R.drawable.car)));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(actualLocation,16));
    }

    private void dibujar(int A) {

        LatLng SN1 = new LatLng(-17.772722, -63.185993);
        LatLng SN2 = new LatLng(-17.773787, -63.183154);
        LatLng SN3 = new LatLng(-17.771966, -63.183407);

        LatLng Hotel = new LatLng(-17.771651, -63.184248);

        LatLng Cre = new LatLng(-17.77292, -63.188937);
        LatLng Multi = new LatLng(-17.773208, -63.188342);
        LatLng Condominio = new LatLng(-17.771492, -63.186136);

        LatLng StarbucksCoffee = new LatLng(-17.772156, -63.188139);
        LatLng Burger_King = new LatLng(-17.770729, -63.183082);
        LatLng KFC = new LatLng(-17.772055, -63.187925);


        if (A == 1) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(SN1).icon(BitmapDescriptorFactory.fromResource(R.drawable.publico_dd));
            InfoWindowData info = new InfoWindowData();
            info.setImage("publico_dd");
            info.setNombre("S/N");
            info.setTelefono("70996680");
            info.setHorarios("Horario: Lunes - Sabado 7:30 - 19:30");
            info.setCosto("(h/5 - d/20 - m/500)bs");
            info.setEspacios("30");

            CustomInfoWindowAdapter customInfoWindow = new CustomInfoWindowAdapter(this);
            mMap.setInfoWindowAdapter(customInfoWindow);

            Marker m = mMap.addMarker(markerOptions);
            m.setTag(info);
            //if ( == true){

            //}
        }
        if (A == 2) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(SN2).icon(BitmapDescriptorFactory.fromResource(R.drawable.publico_dd));
            InfoWindowData info = new InfoWindowData();
            info.setImage("publico_dd");
            info.setNombre("S/N");
            info.setTelefono("70887996");
            info.setHorarios("Lunes - Sabado 8:00 - 20:00");
            info.setCosto("(h/6 - d/30 - m/700)bs");
            info.setEspacios("22");

            CustomInfoWindowAdapter customInfoWindow = new CustomInfoWindowAdapter(this);
            mMap.setInfoWindowAdapter(customInfoWindow);

            Marker m = mMap.addMarker(markerOptions);
            m.setTag(info);
        }
        if (A == 3) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(SN3).icon(BitmapDescriptorFactory.fromResource(R.drawable.publico_oo));
            InfoWindowData info = new InfoWindowData();
            info.setImage("publico_dd");
            info.setNombre("S/N");
            info.setTelefono("71076564");
            info.setHorarios("Lunes - Sabado 7:30 - 19:30");
            info.setCosto("(h/5 - d/30 - m/720)bs");
            info.setEspacios("16");

            CustomInfoWindowAdapter customInfoWindow = new CustomInfoWindowAdapter(this);
            mMap.setInfoWindowAdapter(customInfoWindow);

            Marker m = mMap.addMarker(markerOptions);
            m.setTag(info);
        }
        if (A == 4) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(Hotel).icon(BitmapDescriptorFactory.fromResource(R.drawable.exclusivo_ee));
            InfoWindowData info = new InfoWindowData();
            info.setImage("publico_dd");
            info.setNombre("Hotel Cortez");
            info.setTelefono("3331234");
            info.setHorarios("24 Hrs.");
            info.setCosto("(h/0 - d/0 - m/0)bs");
            info.setEspacios("50");

            CustomInfoWindowAdapter customInfoWindow = new CustomInfoWindowAdapter(this);
            mMap.setInfoWindowAdapter(customInfoWindow);

            Marker m = mMap.addMarker(markerOptions);
            m.setTag(info);
        }
        if (A == 5) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(Cre).icon(BitmapDescriptorFactory.fromResource(R.drawable.exclusivo_ee));
            InfoWindowData info = new InfoWindowData();
            info.setImage("publico_dd");
            info.setNombre("Cre");
            info.setTelefono("3324936");
            info.setHorarios("24 Hrs.");
            info.setCosto("(h/0 - d/0 - m/0)bs");
            info.setEspacios("80");

            CustomInfoWindowAdapter customInfoWindow = new CustomInfoWindowAdapter(this);
            mMap.setInfoWindowAdapter(customInfoWindow);

            Marker m = mMap.addMarker(markerOptions);
            m.setTag(info);
        }
        if (A == 6) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(Multi).icon(BitmapDescriptorFactory.fromResource(R.drawable.exclusivo_ee));
            InfoWindowData info = new InfoWindowData();
            info.setImage("publico_dd");
            info.setNombre("Multi Empresas");
            info.setTelefono("3201798");
            info.setHorarios("Lunes - Sabado 7:30 - 19:30");
            info.setCosto("(h/0 - d/0 - m/0)bs");
            info.setEspacios("300");

            CustomInfoWindowAdapter customInfoWindow = new CustomInfoWindowAdapter(this);
            mMap.setInfoWindowAdapter(customInfoWindow);

            Marker m = mMap.addMarker(markerOptions);
            m.setTag(info);
        }
        if (A == 7) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(Condominio).icon(BitmapDescriptorFactory.fromResource(R.drawable.exclusivo_ee));
            InfoWindowData info = new InfoWindowData();
            info.setImage("publico_dd");
            info.setNombre("Condominio La Casona");
            info.setTelefono("3454236");
            info.setHorarios("24 Hrs.");
            info.setCosto("(h/0 - d/0 - m/0)bs");
            info.setEspacios("120");

            CustomInfoWindowAdapter customInfoWindow = new CustomInfoWindowAdapter(this);
            mMap.setInfoWindowAdapter(customInfoWindow);

            Marker m = mMap.addMarker(markerOptions);
            m.setTag(info);
        }
        if (A == 8) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(StarbucksCoffee).icon(BitmapDescriptorFactory.fromResource(R.drawable.exclusivo_ee));
            InfoWindowData info = new InfoWindowData();
            info.setImage("publico_dd");
            info.setNombre("StarbucksCoffee");
            info.setTelefono("3754454");
            info.setHorarios("24 Hrs.");
            info.setCosto("(h/0 - d/0 - m/0)bs");
            info.setEspacios("20");

            CustomInfoWindowAdapter customInfoWindow = new CustomInfoWindowAdapter(this);
            mMap.setInfoWindowAdapter(customInfoWindow);

            Marker m = mMap.addMarker(markerOptions);
            m.setTag(info);
        }
        if (A == 9) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(Burger_King).icon(BitmapDescriptorFactory.fromResource(R.drawable.exclusivo_ee));
            InfoWindowData info = new InfoWindowData();
            info.setImage("publico_dd");
            info.setNombre("Burger King");
            info.setTelefono("3456455");
            info.setHorarios("24 Hrs.");
            info.setCosto("(h/0 - d/0 - m/0)bs");
            info.setEspacios("20");

            CustomInfoWindowAdapter customInfoWindow = new CustomInfoWindowAdapter(this);
            mMap.setInfoWindowAdapter(customInfoWindow);

            Marker m = mMap.addMarker(markerOptions);
            m.setTag(info);
        }
        if (A == 10) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(KFC).icon(BitmapDescriptorFactory.fromResource(R.drawable.exclusivo_ee));
            InfoWindowData info = new InfoWindowData();
            info.setImage("publico_dd");
            info.setNombre("Kentucky Fried Chicken");
            info.setTelefono("3676575");
            info.setHorarios("24 Hrs.");
            info.setCosto("(h/0 - d/0 - m/0)bs");
            info.setEspacios("15");

            CustomInfoWindowAdapter customInfoWindow = new CustomInfoWindowAdapter(this);
            mMap.setInfoWindowAdapter(customInfoWindow);

            Marker m = mMap.addMarker(markerOptions);
            m.setTag(info);
        }
    }

    public void botonruta(View v){
        InfoWindowData info = new InfoWindowData();

        if(info.getTelefono() == "3676575"){

            LatLng KFC = new LatLng(-17.772055, -63.187925);
            /////////////////////////////////////////
            //LatLng destino = new LatLng(Double.parseDouble(-63.185993),Double.parseDouble(-17.772722));
            LatLng destino = new LatLng(-17.772055, -63.187925);
            MarkerOptions marcadorDestino= new MarkerOptions();
            marcadorDestino.position(destino);
            marcadorDestino.title("Este es tu destino");
            //marcadorDestino.icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("ic_marcador_destino",80,80)));
            mMap.addMarker(marcadorDestino);

            String url = obtenerDireccionesURL(anteriorLocation, destino);
            DownloadTask downloadTask = new DownloadTask();
            downloadTask.execute(url);

            ////////////////////////////////////////
        }
    }


    //////////////////////////Para la funcion del buscador///////////////////////
    private void init(){
        //Log.d(Tag, "init: initializing");
        Log.d(TAG, "init: initializing");

        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, this)
                .build();

        mSearchText.setOnItemClickListener(mAutocompleteClickListener);

        mPlaceAutocompleteAdapter = new PlaceAutocompleteAdapter(this, mGoogleApiClient,
                LAT_LNG_BOUNDS, null);

        mSearchText.setAdapter(mPlaceAutocompleteAdapter);

        mSearchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH
                        || actionId == EditorInfo.IME_ACTION_DONE
                        || event.getAction() == KeyEvent.ACTION_DOWN
                        || event.getAction() == KeyEvent.KEYCODE_ENTER){

                    //ejecutar los metodos de busqueda
                    geoLocate();
                }
                return false;
            }
        });

        mGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked gps icon");
                getDeviceLocation();
            }
        });

        mInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked place info");
                try{
                    if(mMarker.isInfoWindowShown()){
                        mMarker.hideInfoWindow();
                    }else{
                        Log.d(TAG, "onClick: place info: " + mPlace.toString());
                        mMarker.showInfoWindow();
                    }
                }catch (NullPointerException e){
                    Log.e(TAG, "onClick: NullPointerException: " + e.getMessage() );
                }
            }
        });

        mPlacePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

                try {
                    startActivityForResult(builder.build(MapsActivity.this), PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    Log.e(TAG, "onClick: GooglePlayServicesRepairableException: " + e.getMessage() );
                } catch (GooglePlayServicesNotAvailableException e) {
                    Log.e(TAG, "onClick: GooglePlayServicesNotAvailableException: " + e.getMessage() );
                }
            }
        });

        hideSoftKeyboard();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(this, data);

                PendingResult<PlaceBuffer> placeResult = Places.GeoDataApi
                        .getPlaceById(mGoogleApiClient, place.getId());
                placeResult.setResultCallback(mUpdatePlaceDetailsCallback);
            }
        }
    }


    private void geoLocate(){
        Log.d(TAG, "geoLocate: geolocating");
        String searchString = mSearchText.getText().toString();
        Geocoder geocoder = new Geocoder(MapsActivity.this);
        List<Address> list = new ArrayList<>();
        try {
            list = geocoder.getFromLocationName(searchString,1);
        }catch (IOException e){
            Log.e(TAG, "geoLocate: IOException: "+ e.getMessage());
        }

        if(list.size()>0){
            Address address = list.get(0);
            Log.d(TAG, "geoLocate: found a location:"+ address.toString());
            //moveCamera(new LatLng(address.getLatitude(),address.getLongitude()),DEFAULT_ZOOM);
            moveCamera(new LatLng(address.getLatitude(), address.getLongitude()), DEFAULT_ZOOM,
                    address.getAddressLine(0));
        }

    }

    private void moveCamera(LatLng latLng, float zoom, PlaceInfo placeInfo){
        Log.d(TAG, "moveCamera: moving the camera to: lat: " + latLng.latitude + ", lng: " + latLng.longitude );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));

        mMap.clear();

        mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(MapsActivity.this));

        if(placeInfo != null){
            try{
                String snippet = "Address: " + placeInfo.getAddress() + "\n" +
                        "Phone Number: " + placeInfo.getPhoneNumber() + "\n" +
                        "Website: " + placeInfo.getWebsiteUri() + "\n" +
                        "Price Rating: " + placeInfo.getRating() + "\n";

                MarkerOptions options = new MarkerOptions()
                        .position(latLng)
                        .title(placeInfo.getName())
                        .snippet(snippet);
                mMarker = mMap.addMarker(options);

            }catch (NullPointerException e){
                Log.e(TAG, "moveCamera: NullPointerException: " + e.getMessage() );
            }
        }else{
            mMap.addMarker(new MarkerOptions().position(latLng));
        }

        hideSoftKeyboard();
    }

    private void moveCamera(LatLng latLng, float zoom, String title){
        Log.d(TAG, "moveCamera: moving the camera to: lat: " + latLng.latitude + ", lng: " + latLng.longitude );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));

        if(!title.equals("My Location")){
            MarkerOptions options = new MarkerOptions()
                    .position(latLng)
                    .title(title);
            mMap.addMarker(options);
        }

        hideSoftKeyboard();
    }

    private void hideSoftKeyboard(){
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    /*
        --------------------------- google places API autocomplete suggestions -----------------
     */

    private AdapterView.OnItemClickListener mAutocompleteClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            hideSoftKeyboard();

            final AutocompletePrediction item = mPlaceAutocompleteAdapter.getItem(i);
            final String placeId = item.getPlaceId();

            PendingResult<PlaceBuffer> placeResult = Places.GeoDataApi
                    .getPlaceById(mGoogleApiClient, placeId);
            placeResult.setResultCallback(mUpdatePlaceDetailsCallback);
        }
    };

    private ResultCallback<PlaceBuffer> mUpdatePlaceDetailsCallback = new ResultCallback<PlaceBuffer>() {
        @Override
        public void onResult(@NonNull PlaceBuffer places) {
            if(!places.getStatus().isSuccess()){
                Log.d(TAG, "onResult: Place query did not complete successfully: " + places.getStatus().toString());
                places.release();
                return;
            }
            final Place place = places.get(0);

            try{
                mPlace = new PlaceInfo();
                mPlace.setName(place.getName().toString());
                Log.d(TAG, "onResult: name: " + place.getName());
                mPlace.setAddress(place.getAddress().toString());
                Log.d(TAG, "onResult: address: " + place.getAddress());
//                mPlace.setAttributions(place.getAttributions().toString());
//                Log.d(TAG, "onResult: attributions: " + place.getAttributions());
                mPlace.setId(place.getId());
                Log.d(TAG, "onResult: id:" + place.getId());
                mPlace.setLatlng(place.getLatLng());
                Log.d(TAG, "onResult: latlng: " + place.getLatLng());
                mPlace.setRating(place.getRating());
                Log.d(TAG, "onResult: rating: " + place.getRating());
                mPlace.setPhoneNumber(place.getPhoneNumber().toString());
                Log.d(TAG, "onResult: phone number: " + place.getPhoneNumber());
                mPlace.setWebsiteUri(place.getWebsiteUri());
                Log.d(TAG, "onResult: website uri: " + place.getWebsiteUri());

                Log.d(TAG, "onResult: place: " + mPlace.toString());
            }catch (NullPointerException e){
                Log.e(TAG, "onResult: NullPointerException: " + e.getMessage() );
            }

            moveCamera(new LatLng(place.getViewport().getCenter().latitude,
                    place.getViewport().getCenter().longitude), DEFAULT_ZOOM, mPlace);

            places.release();
        }
    };

}
