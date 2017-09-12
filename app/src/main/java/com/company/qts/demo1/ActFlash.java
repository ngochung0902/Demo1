package com.company.qts.demo1;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

public class ActFlash extends AppCompatActivity {
    private boolean check = true;
    private Switch sw_flash;
    private boolean Flash = true;
    private android.hardware.Camera camera;
    private android.hardware.Camera.Parameters parameters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_flash);

        check = getApplicationContext()
                .getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        if (check==false)
        {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(ActFlash.this);
            alertDialog.create();
            alertDialog.setTitle("Loi");
            alertDialog.setMessage("khong co den flash");
            alertDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
        }

        getCamera();
        sw_flash = (Switch) findViewById(R.id.sw_flash);

        sw_flash.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (sw_flash.isChecked()==true)
                {
                    openFlash();
                }
                else {
                    offFlash();
                }
            }
        });

    }

    private void getCamera()
    {
        if (camera == null && parameters == null){
            camera = android.hardware.Camera.open();
            parameters = camera.getParameters();
        }
    }

    private void openFlash(){
        if (Flash == true){
            parameters = camera.getParameters();
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(parameters);
            camera.startPreview();
            Flash = false;
        }
    }

    private void offFlash(){
        if (Flash == false){
            parameters = camera.getParameters();
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(parameters);
            camera.stopPreview();
            Flash = true;
        }
    }
}
