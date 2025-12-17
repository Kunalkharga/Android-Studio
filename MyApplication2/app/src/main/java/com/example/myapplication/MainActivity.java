package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button btnAdd, btnSub;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Link with layout file

        // Linking UI elements
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        tvResult = findViewById(R.id.tvResult);

        // Add Button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(num1.getText().toString());
                int b = Integer.parseInt(num2.getText().toString());
                int sum = a + b;
                tvResult.setText("Result: " + sum);
            }
        });

        // Subtract Button
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(num1.getText().toString());
                int b = Integer.parseInt(num2.getText().toString());
                int diff = a - b;
                tvResult.setText("Result: " + diff);
            }
        });
    }
}
