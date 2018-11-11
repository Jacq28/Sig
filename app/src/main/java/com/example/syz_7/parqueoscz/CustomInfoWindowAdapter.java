package com.example.syz_7.parqueoscz;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by syz_7 on 21/4/2018.
 */

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private Context context;

    public CustomInfoWindowAdapter(Context ctx){
        context = ctx;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = ((Activity)context).getLayoutInflater()
                .inflate(R.layout.infowindow_layout, null);

        ImageView imagen = view.findViewById(R.id.info_window_imagen);
        TextView nombre = view.findViewById(R.id.info_window_nombre);
        TextView telefono = view.findViewById(R.id.info_window_telefono);
        TextView horario = view.findViewById(R.id.info_window_horario);
        TextView costo = view.findViewById(R.id.info_window_costo);
        TextView espacio = view.findViewById(R.id.info_window_espacio);

        //nombre.setText(marker.getTitle());
        //telefono.setText(marker.getSnippet());

        InfoWindowData infoWindowData = (InfoWindowData) marker.getTag();

        int imageId = context.getResources().getIdentifier(infoWindowData.getImage().toLowerCase(),
                "drawable", context.getPackageName());
        imagen.setImageResource(imageId);

        nombre.setText("Nombre: "+infoWindowData.getNombre());
        telefono.setText("Telfono: "+infoWindowData.getTelefono());
        horario.setText("Horario: "+infoWindowData.getHorarios());
        costo.setText("Costo: "+infoWindowData.getCosto());
        espacio.setText("Espacios: "+infoWindowData.getEspacios());



        return view;

    }

}