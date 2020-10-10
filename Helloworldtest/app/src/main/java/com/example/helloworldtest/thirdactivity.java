package com.example.helloworldtest;

import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.util.Log;

public class thirdactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("thirdactivity","Task id is"+getTaskId());
        setContentView(R.layout.third_layout);
    }
}
