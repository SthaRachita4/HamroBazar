package com.example.recycleview.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recycleview.model.MyDataModel;
import com.example.recycleview.R;
import com.example.recycleview.view.CustomAdapter;

public class MainActivity extends AppCompatActivity {
private RecyclerView rv;
private MyDataModel mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv);
        mv=new MyDataModel();
        String[] title=mv.getTitle();
        String[] description=mv.getDescription();
        Integer[] image=mv.getProgramimage();



        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new CustomAdapter(this,title,description,image));

    }
}