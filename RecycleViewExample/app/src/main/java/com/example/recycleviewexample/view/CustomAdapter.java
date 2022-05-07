package com.example.recycleviewexample.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewexample.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private  Context context;
   private String[] namedata;
   private String[] addressdata;


    public CustomAdapter(Context c,String[] names,String[] address){
      context=c;
      namedata=names;
      addressdata=address;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //layout inflate
        View convertView= LayoutInflater.from(context).inflate(R.layout.single_item,null);
        MyViewHolder myViewHolder= new MyViewHolder(convertView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
   //data set
        holder.namesTv.setText(namedata[position]);
        holder.addressTv.setText(addressdata[position]);
    }

    @Override
    public int getItemCount() {
        return namedata.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView namesTv,addressTv;
        public MyViewHolder(View view){
            super(view);
            namesTv = view.findViewById(R.id.tvname);
        addressTv= view.findViewById(R.id.tvaddress);

        }
    }
}


