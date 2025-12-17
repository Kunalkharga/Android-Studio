package com.example.classwork;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> facultyList;
    private ArrayAdapter<String> adapter;
    private int idCounter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nameEditText = findViewById(R.id.nameEditText);
        EditText addressEditText = findViewById(R.id.addressEditText);
        Button addButton = findViewById(R.id.addButton);
        ListView facultyListView = findViewById(R.id.facultyListView);

        facultyList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, facultyList);
        facultyListView.setAdapter(adapter);

        addButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            String address = addressEditText.getText().toString();

            if (!name.isEmpty() && !address.isEmpty()) {
                Faculty faculty = new Faculty(idCounter++, name, address);
                facultyList.add(faculty.getName() + " - " + faculty.getAddress());
                adapter.notifyDataSetChanged();
                nameEditText.setText("");
                addressEditText.setText("");
            }
        });
    }
}