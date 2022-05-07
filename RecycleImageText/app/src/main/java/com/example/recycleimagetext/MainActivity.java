package com.example.recycleimagetext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter programAdapter;
    RecyclerView.LayoutManager layoutManager;
    private String[] names={"Anuj","Rachita","Saru","Rachana","Chuman","Sumana","Garima",
            "Anuj","Rachita","Saru","Rachana","Chuman","Sumana","Garima",
            "Anuj","Rachita","Saru","Rachana","Chuman","Sumana","Garima",
            "Anuj","Rachita","Saru","Rachana","Chuman","Sumana","Garima",
            "Anuj","Rachita","Saru","Rachana","Chuman","Sumana","Garima",
            "Anuj","Rachita","Saru","Rachana","Chuman","Sumana","Garima"
    };

    private String[] address={"Kathmandu","Kathmandu","Kathmandu","kathandu","Kathmandu","kathandu","Kathmandu",
            "Kathmandu","kathmandu","Kathmandu","kathmandu","Kathmandu","kathandu","Kathmandu",
            "Kathmandu","kathmandu","Kathmandu","kathmandu","Kathmandu","kathandu","Kathmandu",
            "Kathmandu","kathmandu","Kathmandu","kathmandu","Kathmandu","kathandu","Kathmandu",
            "Kathmandu","kathmandu","Kathmandu","kathmandu","Kathmandu","kathandu","Kathmandu"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvprogram);
    }
}