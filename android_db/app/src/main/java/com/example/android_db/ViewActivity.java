package com.example.android_db;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {
    private RecyclerView rv;
    private ArrayList<DataModel> dm=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_record);
        rv=findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        DbHelper db=new DbHelper(this);
        dm=db.getRecords();
        rv.setAdapter(new CustomAdapter(this,dm));

    }
}
