package com.example.guangbo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
  private ForceOfflineReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }
    @Override
    protected void onResume(){
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.guangbo.FORCE_OFFLINE");
        receiver = new ForceOfflineReceiver();
        registerReceiver(receiver,intentFilter);
    }

    @Override
    protected void onPause(){
        super.onPause();
        if(receiver!=null){
            unregisterReceiver(receiver);
            receiver = null;
        }
    }

    protected void onDestory(){
        super.onDestroy();
       ActivityCollector.removeActivity(this);
   }
public class ForceOfflineReceiver extends BroadcastReceiver{
        @Override
    public void onReceive(final Context context, Intent intent){
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("warning");
            builder.setMessage("you force to be offline");
            builder.setCancelable(false);
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    ActivityCollector.finishAll();
                    Intent i = new Intent(context,Secondactivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                }
            });
            builder.show();
        }
}
}
