package com.example.android_db;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter <CustomAdapter.MyViewHolder>{
    Context c;
    ArrayList<DataModel> data = new ArrayList<>() ;

    public CustomAdapter(ViewActivity viewActivity, ArrayList<DataModel> dm) {
      c= viewActivity;
      data=dm;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView= LayoutInflater.from(c).inflate(R.layout.single_item,null);
        MyViewHolder myViewHolder=new MyViewHolder(convertView);
        return  myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
     holder.text1.setText(data.get(position).getName());
     holder.text2.setText(""+data.get(position).getStid());
     holder.text3.setText(data.get(position).getFaculty());
     holder.text4.setText(""+data.get(position).getSem());
     holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
         @Override
         public boolean onLongClick(View view) {
             AlertDialog.Builder builder= new AlertDialog.Builder(c);
             View v=LayoutInflater.from(c).inflate(R.layout.record_edit,null);
             builder.setView(v);
             AlertDialog alert=builder.create();
             alert.show();
             EditText stid=v.findViewById(R.id.id);
             EditText semester=v.findViewById(R.id.sem);
             Button edit=v.findViewById(R.id.update);
             Button delete=v.findViewById(R.id.delete);
             stid.setText(data.get(holder.getAdapterPosition()).getStid()+"");
             semester.setText(data.get(holder.getAdapterPosition()).getSem()+"");
             edit.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                 DataModel dm = new DataModel();
                 dm.setStid(data.get(holder.getAdapterPosition()).getStid());
                 dm.setSem(Integer.parseInt(semester.getText().toString()));
                 DbHelper db=new DbHelper(c);
                 db.updateRecord(dm);
                 alert.dismiss();
                     Toast.makeText(c, "Update Successfully", Toast.LENGTH_SHORT).show();
                 }
             });
             delete.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     DbHelper db=new DbHelper(c);
                     db.deleteRecord(data.get(holder.getAdapterPosition()).getStid());
                     alert.dismiss();
                     Toast.makeText(c, "Delete Successfully", Toast.LENGTH_SHORT).show();
                 }
             });
             return true;
         }
     });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text1,text2,text3,text4;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1=itemView.findViewById(R.id.textView);
            text2=itemView.findViewById(R.id.textView2);
            text3=itemView.findViewById(R.id.textView3);
            text4=itemView.findViewById(R.id.textView4);


        }
    }
}
