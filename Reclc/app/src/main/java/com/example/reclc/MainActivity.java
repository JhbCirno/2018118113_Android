package com.example.reclc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<people> peopleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPeople();
        PeopleAdapter adapter = new PeopleAdapter(
                MainActivity.this, R.layout.people_item,peopleList);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        Log.d("MainActivaty",this.toString());
        Button button1= (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,secondactivity.class);
            }
        });
        }

    private void initPeople(){
        for (int i=0;i<1;i++){
            people max = new people("max",R.drawable.makesi);
            peopleList.add(max);
            people liening = new people("liening",R.drawable.liening);
            peopleList.add(liening);
            people enlai = new people("enlai",R.drawable.enlai);
            peopleList.add(enlai);
            people zedong = new people("zedong",R.drawable.maozedong);
            peopleList.add(zedong);
            people sidal = new people("sidal",R.drawable.sidalin);
            peopleList.add(sidal);
            people engesi = new people("engesi",R.drawable.engesi);
            peopleList.add(engesi);
        }
    }

}
