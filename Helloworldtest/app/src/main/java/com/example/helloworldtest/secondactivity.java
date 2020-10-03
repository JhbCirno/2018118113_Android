package com.example.helloworldtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class secondactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("secondactivity",this.toString());
        setContentView(R.layout.second_layout);
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(secondactivity.this,Firstactivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected  void onDestroy(){
        super.onDestroy();
        Log.d("secondactivity","onDestory");
    }
}
