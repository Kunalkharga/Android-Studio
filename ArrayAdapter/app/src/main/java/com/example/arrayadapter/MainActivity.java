package com.example.arrayadapter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] fruits = {"Bike", "Scotte", "Car", "Bus", "Truck", "Cycle"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(MainActivity.this, R.layout.list_item, R.id.textItem, fruits);

        listView.setAdapter(adapter);
    }
}
