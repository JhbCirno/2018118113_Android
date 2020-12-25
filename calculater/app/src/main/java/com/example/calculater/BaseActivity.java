package com.example.calculater;

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
    protected void onCreate(Bundle savedInstan){
        super.onCreate(savedInstan);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onResume(){
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.calculater.FORCE_OFFLINE");
        receiver = new ForceOfflineReceiver();
        registerReceiver(receiver,intentFilter);
    }
    @Override
    protected void onPause(){
        super.onPause();
        if (receiver !=null){
            unregisterReceiver(receiver);
            receiver = null;
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.delActivity(this);
    }
    class ForceOfflineReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(final Context context, final Intent intent){
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("退出");
            builder.setMessage("你退出了程序");
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    ActivityCollector.finishAll();
                    Intent a = new Intent(context,LoginActivity.class);
                    context.startActivity(a);
                }
            });
            builder.show();
        }
    }
}
