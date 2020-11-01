package com.example.guangbo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private IntentFilter intentFilter;
  private NetworkChangeRecevier networkChangeRecevier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*收集自定义广播*/
        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.guangbo.MY_BROADCAST");
                intent.setComponent(new ComponentName("com.example.guangbo","com.example.guangbo.MyBoradcastReceiver"));
                sendBroadcast(intent);
            }
        });
/* 跳转页面 */
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Secondactivity.class);
                startActivity(intent);
            }
        });
/*启动app发广播*/
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeRecevier = new NetworkChangeRecevier();
        registerReceiver(networkChangeRecevier, intentFilter);
    }
    protected void onDestory() {
        super.onDestroy();
        unregisterReceiver(networkChangeRecevier);
    }
    class NetworkChangeRecevier extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent){
            ConnectivityManager connectionManager = (ConnectivityManager)getSystemService(context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
            if (networkInfo != null &&networkInfo.isAvailable()){
                Toast.makeText(context,"network is available",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context,"network is unavable",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
