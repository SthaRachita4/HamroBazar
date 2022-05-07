package com.example.recycleview.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
    private Context context;
    private String[] titledata;
    private String[] descriptiondata;
    private Integer[] imagedata;

    public  CustomAdapter(Context c, String[] title, String[] description, Integer[] image){
        context=c;
        titledata=title;
        descriptiondata=description;
        imagedata=image;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView= LayoutInflater.from(context).inflate(R.layout.single_item,null);
        MyViewHolder myViewHolder=new MyViewHolder(convertView);
        return  myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
holder.text1.setText(titledata[position]);
holder.text2.setText(descriptiondata[position]);
holder.imageview.setImageResource(imagedata[position]);
    }

    @Override
    public int getItemCount() { return titledata.length; }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text1,text2;
        ImageView imageview;
        public MyViewHolder(View view){
            super(view);
            text1=view.findViewById(R.id.textview1);
            text2=view.findViewById(R.id.textview2);
            imageview=view.findViewById(R.id.imageView);
        }
    }
}

