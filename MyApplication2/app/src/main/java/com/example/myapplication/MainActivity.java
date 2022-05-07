package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentProviderClient;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView result;
    Button add,sub;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result=findViewById(R.id.result);
        add=findViewById(R.id.btn1);
        sub=findViewById(R.id.btn2);

        add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count++;
                    result.setText(count+"");
                }

            });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                result.setText(String.valueOf(count));
            }
        });
    }

}