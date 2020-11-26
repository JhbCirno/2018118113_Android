package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startService = (Button)findViewById(R.id.button1);
        Button stopService = (Button)findViewById(R.id.button2);
        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button1:
                Intent startIntent = new Intent(this,MyService.class);
                startService(startIntent);
                break;
            case R.id.button2:
                Intent stopIntent = new Intent(this,MyService.class);
                stopService(stopIntent);
                break;
        }
    }
}
