package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<people> peopleList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPeople();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyceler1);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(layoutManager);
        PeopleAdapter adapter = new PeopleAdapter(peopleList);
        recyclerView.setAdapter(adapter);
    }
    private void initPeople(){
        for (int i=0;i<2;i++){
            people makesi = new people(getRandomLengthName("makesi"), R.drawable.max);
            peopleList.add(makesi);
            people sidalin = new people(getRandomLengthName("makesi"), R.drawable.sidalin);
            peopleList.add(sidalin);
            people zedong = new people(getRandomLengthName("makesi"), R.drawable.zedong);
            peopleList.add(zedong);
            people liening = new people(getRandomLengthName("makesi"), R.drawable.liening);
            peopleList.add(liening);
            people enlai = new people(getRandomLengthName("makesi"), R.drawable.enlai);
            peopleList.add(enlai);
            people engesi = new people(getRandomLengthName("engesi"), R.drawable.engesi);
            peopleList.add(engesi);
        }
    }
    private String getRandomLengthName(String name){
        Random random = new Random();
        int length=random.nextInt(20)+1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i<length;i++){
            builder.append(name);
        }
        return builder.toString();
    }
}
