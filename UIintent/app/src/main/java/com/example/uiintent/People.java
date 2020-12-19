package com.example.uiintent;

public class People {
    private String name;
    private int Imageid;
    public People(String name,int Imageid){
        this.name = name;
        this.Imageid = Imageid;
    }
    public String getName(){
        return name;
    }
    public int getImageid(){
        return Imageid;
    }
}
