package com.example.guangbo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
  private ForceOffLineReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    protected void onDestory(){
        super.onDestroy();
       ActivityCollector.removeActivity(this);
   }
class ForceOfflineReceiver extends BroadcastReceiver{

}
}
