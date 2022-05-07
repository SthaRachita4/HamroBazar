package com.example.android_db;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button add, view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=findViewById(R.id.add);
        view=findViewById(R.id.view);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertBuilder= new AlertDialog.Builder(MainActivity.this);
                View view=getLayoutInflater().inflate(R.layout.add_record,null);
                alertBuilder.setView(view);
                AlertDialog alert=alertBuilder.create();
                alert.show();
                EditText etName= view.findViewById(R.id.name);
                EditText etStid= view.findViewById(R.id.studentid);
                EditText etFaculty= view.findViewById(R.id.faculty);
                EditText etSem= view.findViewById(R.id.semestar);
                Button save=view.findViewById(R.id.save);
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DbHelper db=new DbHelper(MainActivity.this);
                        DataModel data=new DataModel();
                        data.setName(etName.getText().toString());
                        data.setStid(Integer.parseInt(etStid.getText().toString()));
                        data.setFaculty(etFaculty.getText().toString());
                        data.setSem(Integer.parseInt(etSem.getText().toString()));
                        db.addRecord(data);
                        alert.dismiss();
                        Toast.makeText(MainActivity.this,"Record Added SuccessfullY"
                        ,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             startActivity(new Intent(MainActivity.this,ViewActivity.class));
            }
        });
    }
}