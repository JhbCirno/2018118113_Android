package com.example.recyclerview;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder>{
    private List<people> mpeopleList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View peopleView;
        ImageView peopleImage;
        TextView peoplename;
        public ViewHolder(View view){
            super(view);
            peopleView = view;
            peopleImage=(ImageView)view.findViewById(R.id.people_image);
            peoplename=(TextView)view.findViewById(R.id.people_text);
        }
    }
    public PeopleAdapter(List<people> peopleList){
        mpeopleList=peopleList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.people_item,parent,false);
       final ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int postion){
        people people = mpeopleList.get(postion);
        holder.peopleImage.setImageResource(people.getImageId());
        holder.peoplename.setText(people.getName());
    }
    @Override
    public int getItemCount(){
        return mpeopleList.size();
    }
}
