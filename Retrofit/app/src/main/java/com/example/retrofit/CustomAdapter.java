package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter <CustomAdapter.MyViewHolder>{
    Context c;
    List<Example> data;



    public CustomAdapter(MainActivity mainActivity, List<Example> myData) {
        c=mainActivity;
        data=myData;
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
        holder.text1.setText(data.get(position).getName());
        holder.text1.setText(data.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text1,text2,text3,text4,text5;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1=itemView.findViewById(R.id.name);
            text2=itemView.findViewById(R.id.email);
        }
    }
}
