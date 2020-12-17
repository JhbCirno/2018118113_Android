package com.example.uithread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyService.DownloadBinder downloadBinder;
private TextView text;
public static final int UPDATE_TEXT=1;
private Handler handler = new Handler(){
    public void handleMessage(Message msg){
        switch(msg.what){
            case UPDATE_TEXT:
                text.setText("Nice to meet you");
                break;
             default:
                 break;
        }
    }};

private ServiceConnection connection = new ServiceConnection() {
    @Override
    public void onServiceConnected(ComponentName componentName, IBinder service) {
        downloadBinder = (MyService.DownloadBinder) service;
        downloadBinder.startDownload();
        downloadBinder.getProgress();
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bindService = (Button)findViewById(R.id.bind_service);
        Button unbindService = (Button)findViewById(R.id.Unbind_service);
        Button StartService = (Button)findViewById(R.id.start_service);
        Button StopService = (Button)findViewById(R.id.stop_service);
        StartService.setOnClickListener(this);
        StopService.setOnClickListener(this);
        bindService.setOnClickListener(this);
        unbindService.setOnClickListener(this);

        text = (TextView)findViewById(R.id.text);
        Button changeText = (Button)findViewById(R.id.change_text);
        changeText.setOnClickListener(this);
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.change_text:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = UPDATE_TEXT;
                        handler.sendMessage(message);
                    }
                }).start();
            case R.id.start_service:
                Intent intent = new Intent(this,MyService.class);
                startService(intent);
                break;
            case R.id.stop_service:
                Intent intent1 = new Intent(this,MyService.class);
                stopService(intent1);
                break;
            case R.id.bind_service:
                Intent intent2 = new Intent(this,MyService.class);
                bindService(intent2,connection,BIND_AUTO_CREATE);
                break;
            case R.id.Unbind_service:
                unbindService(connection);
                break;

             default:
                 break;
        }
    }

}
