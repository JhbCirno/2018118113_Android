package com.example.reclc;

public class people {
    private String name;
    private int imageId;
    public  people(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
