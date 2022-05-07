package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv=findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface=ApiClient.getClient().create(ApiInterface.class);
        Call<List<Example>> data=apiInterface.getData();
        data.enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
              List<Example> myData=response.body();
              rv.setAdapter(new CustomAdapter(MainActivity.this,myData));

            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"No Data received",Toast.LENGTH_SHORT).show();
            }
        });
    }
}