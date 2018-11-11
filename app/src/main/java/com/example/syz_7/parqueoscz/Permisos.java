package com.example.syz_7.parqueoscz;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Permisos extends AppCompatActivity {

    final private int REQUEST_CODE_ASK_PERMISSIONS = 124;
    int hasReadSendSMSPermissions;
    final private int REQUEST_CODE_ASK_PERMISSIONST = 124;
    int hasReadSendSMSPermissionsT;
    final private int REQUEST_CODE_ASK_PERMISSIONSTT = 124;
    int hasReadSendSMSPermissionsTT;

    private void accessPermission(){
        hasReadSendSMSPermissions =checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION);

        if (hasReadSendSMSPermissions != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE_ASK_PERMISSIONS);
        }
    }

    private void accessPermissionT(){
        hasReadSendSMSPermissionsT =checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION);

        if (hasReadSendSMSPermissionsT != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},REQUEST_CODE_ASK_PERMISSIONST);
        }
    }

    private void accessPermissionTT(){
        hasReadSendSMSPermissionsT =checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (hasReadSendSMSPermissionsT != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_CODE_ASK_PERMISSIONST);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
        switch (requestCode){
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(Permisos.this, "Permissions granted", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Permisos.this, "Permissions denied", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        }
        switch (requestCode){
            case REQUEST_CODE_ASK_PERMISSIONST:
                if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(Permisos.this, "Permissions granted", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Permisos.this, "Permissions denied", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        }
        switch (requestCode){
            case REQUEST_CODE_ASK_PERMISSIONSTT:
                if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(Permisos.this, "Permissions granted", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Permisos.this, "Permissions denied", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        }
    }

    TextView empezar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permisos);
        accessPermission();
        accessPermissionT();
        accessPermissionTT();
        empezar = (TextView) findViewById(R.id.textView);
    }
    public void entrar (View v){
        Intent intent = new Intent(Permisos.this, MenuActivity.class);
        startActivity(intent);
    }

    public void registrar (View v){
        Intent intent = new Intent(Permisos.this, Registro.class);
        startActivity(intent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            //Acción
        }
        return false;
    }
}
