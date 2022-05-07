package com.example.recycleviewexample.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recycleviewexample.R;
import com.example.recycleviewexample.model.MyDataModel;
import com.example.recycleviewexample.view.CustomAdapter;

public class MainActivity extends AppCompatActivity {
private RecyclerView rv;
private MyDataModel mv;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        //data fetch
        mv=new MyDataModel();
        String[] names =mv.getNames();
        String[] address= mv.getAddress();


        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new CustomAdapter(this,names,address));
    }
}