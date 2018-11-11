package com.example.syz_7.parqueoscz;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Registro extends AppCompatActivity {

    Button guardar;
    //(nick,equipo,nivel,privilegio,telf,imei,pin,email)
    public Button registrar, nvob7,nvob2;
    public EditText nombreE, apellidoE, ciE, direccionE, telfE, emailE, passE;
    public Spinner genero, diaSpinner,mesSpinner,yearSpinner;
    Boolean verdad=false;
    public TextView tvGenero;
    String Simei, Stelf, Scodigo;
    String Nombre, Apellido, Ci, Sexo, Direccion, Telf, Email, Pass, fecha_nac, dia_nac, mes_nac, year_nac;
    String finalResult ;
    //proyectowebandroid/public_html/parqueo/DatabaseConfig.php
    //String HttpURL = "https://proyectowebandroid/public_html/parqueo/registro_user.php";
    //files.000webhost.com
    String HttpURL = "https://proyectowebandroid.files.000webhost.com/parqueo/registro_user.php";
    Boolean CheckEditText ;
    ProgressDialog progressDialog;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        guardar = (Button) findViewById(R.id.button2);
        nombreE = (EditText) findViewById(R.id.editText3);
        apellidoE = (EditText) findViewById(R.id.editText4);
        ciE = (EditText) findViewById(R.id.editText6);
        direccionE = (EditText) findViewById(R.id.editText8);
        telfE = (EditText) findViewById(R.id.editText9);
        emailE = (EditText) findViewById(R.id.editText10);
        passE = (EditText) findViewById(R.id.editText11);
        genero = (Spinner) findViewById(R.id.spinner);
        diaSpinner = (Spinner) findViewById(R.id.spinner5);
        mesSpinner = (Spinner) findViewById(R.id.spinner4);
        yearSpinner = (Spinner) findViewById(R.id.spinner3);
        checkBox = (CheckBox) findViewById(R.id.checkBox3);

        String[] valores = {"Masculino","Femenino","Otro"};
        genero.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));
        genero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                //Equipo = (String) adapterView.getItemAtPosition(position);

                if (adapterView.getItemAtPosition(position)== "Masculino"){
                    Sexo= "M";
                }else if (adapterView.getItemAtPosition(position)== "Femenino"){
                    Sexo= "F";
                }else if (adapterView.getItemAtPosition(position)== "Otro"){
                    Sexo= "O";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // vacio
            }
        });

        String[] dias = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        diaSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dias));
        diaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                dia_nac = (String) adapterView.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // vacio
            }
        });

        String[] meses = {"01","02","03","04","05","06","07","08","09","10","11","12"};
        mesSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, meses));
        mesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                mes_nac = (String) adapterView.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // vacio
            }
        });

        String[] year = {"1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989",
                "1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001"};
        yearSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, year));
        yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                year_nac = (String) adapterView.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // vacio
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Checking whether EditText is Empty or Not
                CheckEditTextIsEmptyOrNot();

                if(CheckEditText && checkBox.isChecked()==true){

                    // If EditText is not empty and CheckEditText = True then this block will execute.
                    //'1995-01-29'
                    fecha_nac = year_nac +"-"+ mes_nac +"-"+ dia_nac;
                    UserRegisterFunction(Nombre, Apellido, Ci, Sexo, Direccion, Telf, Email, Pass, fecha_nac);
                    //UserRegisterFunction(Nick,Equipo,Pin,Email);
                }
                else {

                    // If EditText is empty then this block will execute .
                    Toast.makeText(Registro.this, "Debe llenar todos los campos y aceptar las reglas", Toast.LENGTH_LONG).show();

                }


            }
        });

    }

    public void CheckEditTextIsEmptyOrNot(){
        //Nombre, Apellido, Ci, Sexo, Direccion, Telf, Email, Pass, fecha_nac, dia_nac, mes_nac, year_nac
        //nombreE, apellidoE, ciE, direccionE, telfE, emailE, passE
        Nombre = nombreE.getText().toString();
        Apellido = apellidoE.getText().toString();
        Ci = ciE.getText().toString();
        Direccion = direccionE.getText().toString();
        Telf = telfE.getText().toString();
        Email = emailE.getText().toString();
        Pass = passE.getText().toString();




        if(TextUtils.isEmpty(Nombre) || TextUtils.isEmpty(Apellido) || TextUtils.isEmpty(Ci) || TextUtils.isEmpty(Direccion) || TextUtils.isEmpty(Telf) || TextUtils.isEmpty(Email) || TextUtils.isEmpty(Pass))
        {

            CheckEditText = false;

        }
        else {

            CheckEditText = true ;
        }
    }

    public void UserRegisterFunction(final String Nombre, final String Apellido, final String Ci, final String Sexo, final String Direccion, final String Telf, final String Email, final String Pass, final String fecha_nac){

        class UserRegisterFunctionClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(Registro.this,"Loading Data",null,true,true);
            }

            @Override
            public void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();
                if (httpResponseMsg.toString().equals("Registration Successfully")) {

                    Toast.makeText(Registro.this, httpResponseMsg.toString(), Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(Registro.this, Permisos.class);
                    startActivity(intent);
                }
                Toast.makeText(Registro.this, httpResponseMsg.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("nombre",params[0]);

                hashMap.put("apellido",params[1]);

                hashMap.put("ci",params[2]);

                hashMap.put("sexo",params[3]);

                hashMap.put("direccion",params[4]);

                hashMap.put("telf",params[5]);

                hashMap.put("email",params[6]);

                hashMap.put("pass",params[7]);

                hashMap.put("fecha",params[8]);

                finalResult = httpParse.postRequest(hashMap, HttpURL);

                return finalResult;
            }


        }

        UserRegisterFunctionClass userRegisterFunctionClass = new UserRegisterFunctionClass();

        userRegisterFunctionClass.execute(Nombre, Apellido, Ci, Sexo, Direccion, Telf, Email, Pass, fecha_nac);

    }

}
