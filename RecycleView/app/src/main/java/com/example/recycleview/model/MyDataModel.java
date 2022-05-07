package com.example.recycleview.model;

import com.example.recycleview.R;

public class MyDataModel {
    private String[] title = {"Like", "care", "Happy", "Love", "sad","Angry"};

    private String[] description = {"Like Description","Care Description","Happy Description","Love Description","Sad Description","Angry Description"};

  private Integer[] programimage={R.drawable.like,R.drawable.care,R.drawable.happy,R.drawable.love,
          R.drawable.sad,R.drawable.angry};

    public String[] getTitle() { return title;}
    public  String[] getDescription(){return description;}
    public Integer[] getProgramimage(){return programimage;}
}

