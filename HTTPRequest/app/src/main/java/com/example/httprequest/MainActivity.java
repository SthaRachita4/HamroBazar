package com.example.httprequest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RequestQueue rq;
    String url="https://jsonplaceholder.typicode.com/users";
    ArrayList<DataFormat> data=new ArrayList();
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rq= Volley.newRequestQueue(this);
        rv=findViewById(R.id.rv);
        StringRequest sr=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONArray arr = new JSONArray(response);
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj1 = arr.getJSONObject(i);
                        String name = obj1.getString("name");
                        String email = obj1.getString("email");
                        JSONObject obj2 = obj1.getJSONObject("address");
                        String street = obj2.getString("street");
                        JSONObject geo = obj2.getJSONObject("geo");
                        String lat = geo.getString("lat");
                        String lng = geo.getString("lng");
                        DataFormat d = new DataFormat();
                        d.setName(name);
                        d.setEmail(email);
                        d.setStreet(street);
                        d.setLat(lat);
                        d.setLng(lng);
                        data.add(d);

                    }
                   rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    rv.setAdapter(new CustomAdapter(this,data));

                }catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"No Response",Toast.LENGTH_SHORT).show();

            }
        });
        rq.add(sr);

    }
}