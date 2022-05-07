package com.example.multipleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn,passvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btnactivities);
        passvalue=findViewById(R.id.btngo);
        passvalue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,SecondActivity.class);
                Bundle b = new Bundle();
                String myParcel="abc";
                int phone=9860100;
                b.putString("id",myParcel);
                b.putInt("ph",phone);
                i.putExtras(b);
                startActivity(i);

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,FirstActivity.class);
                startActivity(i);
            }
        });

    }
}