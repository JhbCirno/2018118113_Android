package com.example.uiintent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    //定义人物列表
    private People[] people = {new People("max",R.drawable.max),new People("zhouenlai",R.drawable.enlai),
    new People("sidalin",R.drawable.sidalin), new People("maozedong",R.drawable.zedong),
    new People("liening",R.drawable.liening),new People("engesi",R.drawable.engesi)};
    //创建人物表
    private List<People> peopleList = new ArrayList<>();
    //建立People的Recycleview的接收器
    private PeopleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //在onCreate中创建功能的启动和映射
        initPeople();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this , 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PeopleAdapter(peopleList);
        recyclerView.setAdapter(adapter);


//创建Toolbar
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);


//创建悬浮按钮
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
//悬浮按钮的点击事件
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Data deleted",Snackbar.LENGTH_SHORT).setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Data restored", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        NavigationView navView = (NavigationView)findViewById(R.id.nav_view);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_mune);
        }
        navView.setCheckedItem(R.id.nav_call);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.backup:
                Toast.makeText(this,"You clicked Backup",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete :
                Toast.makeText(this,"You clicked Delete",Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting :
                Toast.makeText(this,"You clicked Setting",Toast.LENGTH_SHORT).show();
                break;
             default:
        }
        return true;
    }
    private void initPeople(){
        peopleList.clear();
        for (int i = 0; i < 50 ;i++){
            Random random = new Random();
            int index = random.nextInt(people.length);
            peopleList.add(people[index]);
        }
    }

}
