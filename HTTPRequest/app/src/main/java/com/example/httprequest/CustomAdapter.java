package com.example.httprequest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter <CustomAdapter.MyViewHolder>{
   Context c;
    ArrayList<DataFormat> data= new ArrayList<>();
    public CustomAdapter(Response.Listener<String> listener, ArrayList<DataFormat> data) {
       c= (Context) listener;
        data=data;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(c).inflate(R.layout.single_item,null);
        MyViewHolder myViewHolder=new MyViewHolder(convertView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

     class MyViewHolder extends RecyclerView.ViewHolder {
         TextView text1,text2,text3,text4,text5;
         public  MyViewHolder(@NonNull View itemView){
             super(itemView);
             text1=itemView.findViewById(R.id.name);
             text2=itemView.findViewById(R.id.email);
             text3=itemView.findViewById(R.id.street);
             text4=itemView.findViewById(R.id.lat);
             text5=itemView.findViewById(R.id.lng);
         }

    }
}
