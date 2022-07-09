package com.mastercoding.jsonparsinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Widgets
    ListView listy;

    //JSON STRING
    String json_string = "{\n" +
            " \"title\":\"JSONParserTutorial\",\n" +
            " \"array\":[\n" +
            "  {\n" +
            "  \"company\":\"Google\"\n" +
            "  },\n"+
            "  {\n" +
            "  \"company\" :\"Facebook\"\n" +
            "  },\n"+
            "  {\n" +
            "  \"company\" :\"LinkedIn\"\n" +
            "  },\n"+
            "  {\n" +
            "  \"company\" :\"Microsoft\"\n" +
            "  },\n"+
            "  {\n" +
            "  \"company\" :\"Apple\"\n" +
            "  },\n"+
            "  {\n" + " " +
            " \"company\" :\"Instagram\"\n" +
            "  }\n"+
            "  ], \n" +
            "  \"nested\":{\n" +
            "  \"flag\":true,\n" +
            "  \"random_number\":1\n" +
            "  }\n" +
            "}";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try{
             // getting JSON object
            listy = findViewById(R.id.listview);

            // 1- Storing Items in a list
            List<String> items  = new ArrayList<>();

            // 2- Creating a JSON  object

            JSONObject root = new JSONObject(json_string);

            // 3 - getting data from array
            JSONArray array = root.getJSONArray("array");

            // 4- setting the title
            this.setTitle(root.getString("title"));

            // 5- Loop to get all company details option
            for(int i =0; i<array.length();i++){

                JSONObject object = array.getJSONObject(i);
                items.add(object.getString("company"));

            }

            // 6- Creating adapter
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,items);

            if(listy != null){
                listy.setAdapter(adapter);

            }
            // 7- getting nested objects from the root
            JSONObject nested = root.getJSONObject("nested");

            Log.d("TAG","flag Value" +nested.getBoolean("flag"));


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}