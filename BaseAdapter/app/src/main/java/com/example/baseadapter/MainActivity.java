package com.example.baseadapter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] names = {"Tesla", "BMW", "Ford", "Audi"};
    int[] icons = {R.drawable.fb, R.drawable.ig, R.drawable.tw, R.drawable.yt};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(MainActivity.this, names, icons);

        listView.setAdapter(adapter);
    }
}
