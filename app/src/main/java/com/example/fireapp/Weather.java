package com.example.fireapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.fireapp.Model.DeviceDetails;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

public class Weather extends AppCompatActivity {
    TextView temp, airpressure, humidity, windSpeed, windDirection, ts;
    DatabaseReference ref= FirebaseDatabase.getInstance().getReference();
    DeviceDetails Dd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        temp = findViewById(R.id.temp);
        airpressure = findViewById(R.id.air_pressure);
        humidity = findViewById(R.id.humidity);
        windSpeed = findViewById(R.id.wind_speed);
        windDirection = findViewById(R.id.wind_direction);
        ts = findViewById(R.id.time_stamp);
        CardView Test = findViewById(R.id.Test);
        Dd=new DeviceDetails();



        RetriveData();
        findData();
        Test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Weather.this, pollution_weather.class));
            }
        });
    }

    private void RetriveData() {

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String tempS=dataSnapshot.child("DHT22-1").child("Temperature").getValue(String.class);
                String humidityS=dataSnapshot.child("DHT22-1").child("Humidity").getValue(String.class);
                temp.setText(tempS);
                humidity.setText(humidityS);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {



            }
        });

    }

    private void findData() {
        String url = "https://api.airvisual.com/v2/nearest_city?\"+lat+\"&\"+lon+\"&key=2b55ab05-d20b-4db2-b730-a1e072d323bc";
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject data = response.getJSONObject("data");
                    JSONObject current = data.getJSONObject("current");
                    JSONObject weather = current.getJSONObject("weather");

                    //temp.setText(String.valueOf(weather.getDouble("tp")));
                    airpressure.setText(String.valueOf(weather.getDouble("pr")));
                    //humidity.setText(String.valueOf(weather.getDouble("hu")));
                    windSpeed.setText(String.valueOf(weather.getDouble("ws")));
                    windDirection.setText(String.valueOf(weather.getDouble("wd")));
                    ts.setText(weather.getString("ts"));


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Weather.this, String.valueOf(error), Toast.LENGTH_SHORT).show();
            }
        }
        );
        RequestQueue que = Volley.newRequestQueue(this);
        que.add(jor);
    }



}