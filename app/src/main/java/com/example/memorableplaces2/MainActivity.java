



package com.example.memorableplaces2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.memorableplaces2.MapsActivity;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static ArrayList<String> places = new ArrayList<String>();
    static  ArrayList<LatLng> location = new ArrayList<LatLng>();
   static  ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     /*   SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.memorableplaces2",Context.MODE_PRIVATE);
        ArrayList<String> latitudes = new ArrayList<String>();
        ArrayList<String> longitudes = new ArrayList<String>();

        places.clear();
        longitudes.clear();
        latitudes.clear();

        try {
            places = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("places",ObjectSerializer.serialize(MainActivity.places)));
            latitudes = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("lats",ObjectSerializer.serialize(MainActivity.places)));
            longitudes = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("longs",ObjectSerializer.serialize(MainActivity.places)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (places.size()>0&& longitudes.size()>0&& latitudes.size()>0)
        {
            if ((places.size() == longitudes.size()) && (places.size() == latitudes.size()))
            {
                for (int i = 0 ; i>longitudes.size();i++)
                {
                    location.add(new LatLng(Double.parseDouble(latitudes.get(i)),Double.parseDouble(longitudes.get(i))));

                }
            }
        }
        else
        {
            places.add("Add a new Place..");
            location.add(new LatLng(0,0));
        }*/

        ListView listView = findViewById(R.id.ListView);
        places.add("Add a new Place..");
        location.add(new LatLng(0,0));
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,places);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                intent.putExtra("placesnumber",i);
                Log.i("hi",Integer.toString(i));

                startActivity(intent);
            }
        });

    }
}