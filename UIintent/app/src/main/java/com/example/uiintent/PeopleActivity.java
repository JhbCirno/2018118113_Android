package com.example.uiintent;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class PeopleActivity extends AppCompatActivity {
    public static final String PEOPLE_NAME = "people_name";
    public static final String PEOPLE_IMAGE_ID = "people_Image_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
        Intent intent = getIntent();
        String peopleName = intent.getStringExtra(PEOPLE_NAME);
        int peopleImageId = intent.getIntExtra(PEOPLE_IMAGE_ID,0);
        Toolbar toolbar = (Toolbar)findViewById(R.id.people_toolbar) ;
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        ImageView peopleImageView = (ImageView)findViewById(R.id.people_image_view);
        TextView peopleContentText  = (TextView)findViewById(R.id.people_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(peopleName);
        Glide.with(this).load(peopleImageId).into(peopleImageView);
        String peopleContent = generatePeopleContent(peopleName);
        peopleContentText.setText(peopleContent);
    }

    private String generatePeopleContent(String peopleName){
        StringBuilder peopleContent = new StringBuilder();
        for (int i =0;i<500;i++){
            peopleContent.append(peopleName);
        }
        return peopleContent.toString();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
