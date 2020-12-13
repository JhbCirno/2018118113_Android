package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate(){
        super.onCreate();
        Log.d("MyService","oncreate");
    }
    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        Log.d("MyService","onStart");
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("MyService","onDestroy");
    }
}
