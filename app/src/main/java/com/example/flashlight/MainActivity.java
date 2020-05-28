package com.example.flashlight;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

private ImageButton switch_on, switch_off;
private Camera camera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switch_on = findViewById(R.id.switch_on);
        switch_off = findViewById(R.id.switch_off);

        camera = Camera.open();
        final Camera.Parameters parameters = camera.getParameters();

        switch_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch_off.setVisibility(View.GONE);
                switch_on.setVisibility(View.VISIBLE);
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(parameters);
                camera.startPreview();
            }
        });
        switch_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch_off.setVisibility(View.VISIBLE);
                switch_on.setVisibility(View.GONE);
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                camera.setParameters(parameters);
                camera.stopPreview();
            }
        });
    }
}
