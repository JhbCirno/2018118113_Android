package com.example.uiintent;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder>{
    private Context mContext;
    private List<People> mPeople;
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageView;
        TextView name;
        public ViewHolder(View view){
            super(view);
            cardView=(CardView)view;
            imageView=(ImageView)view.findViewById(R.id.people_image);
            name = (TextView)view.findViewById(R.id.people_name);
        }
    }
    public PeopleAdapter(List<People> peopleList){
        mPeople = peopleList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent , int viewType){
        if(mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.people_item,parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int postion = holder.getAdapterPosition();
                People people = mPeople.get(postion);
                Intent intent =new Intent(mContext,PeopleActivity.class);
                intent.putExtra(PeopleActivity.PEOPLE_NAME,people.getName());
                intent.putExtra(PeopleActivity.PEOPLE_IMAGE_ID,people.getImageid());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }
    public void onBindViewHolder(ViewHolder holder,int postion){
        People people = mPeople.get(postion);
        Glide.with(mContext).load(people.getImageid()).into(holder.imageView);
        holder.name.setText(people.getName());
    }
    @Override
    public int getItemCount(){
        return mPeople.size();
    }
}
