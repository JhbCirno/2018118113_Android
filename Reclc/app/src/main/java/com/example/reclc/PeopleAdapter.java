package com.example.reclc;

import android.content.Context;
import android.icu.text.Transliterator;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PeopleAdapter extends ArrayAdapter<people> {
    private int resourceId;
    public PeopleAdapter(Context context, int textViewResourceId, List<people> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }
    @Override
    public View getView(int position,View convertView, ViewGroup parent){
        people people = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView peopleImage = (ImageView)view.findViewById(R.id.people_image);
        TextView peopleText = (TextView)view.findViewById(R.id.people_name);
        peopleImage.setImageResource(people.getImageId());
        peopleText.setText(people.getName());
        return view;
    }
    }
