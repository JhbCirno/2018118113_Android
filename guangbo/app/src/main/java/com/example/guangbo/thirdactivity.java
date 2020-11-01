package com.example.guangbo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class thirdactivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdactivity_layout);
        Button button = (Button)findViewById(R.id.down);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.guangbo.FORCE_OFFLINE");
                intent.setComponent(new ComponentName("com.example.guangbo","com.example.guangbo.DOWN"));
            }
        });
    }
}
