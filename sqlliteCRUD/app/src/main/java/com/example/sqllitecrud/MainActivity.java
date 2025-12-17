package com.example.sqllitecrud;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.database.Cursor;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtAge, edtId;
    Button btnInsert, btnView, btnUpdate, btnDelete;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // INITIALIZE UI
        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        edtId = findViewById(R.id.edtId);

        btnInsert = findViewById(R.id.btnInsert);
        btnView = findViewById(R.id.btnView);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        db = new DatabaseHelper(this);

        // INSERT
        btnInsert.setOnClickListener(v -> {
            boolean inserted = db.insertData(
                    edtName.getText().toString(),
                    edtAge.getText().toString()
            );

            if (inserted)
                showMessage("Success", "Data Inserted");
            else
                showMessage("Error", "Insert Failed");
        });

        // VIEW ALL
        btnView.setOnClickListener(v -> {
            Cursor c = db.getAllData();
            if (c.getCount() == 0) {
                showMessage("Error", "No Data Found");
                return;
            }

            StringBuilder sb = new StringBuilder();
            while (c.moveToNext()) {
                sb.append("ID: ").append(c.getString(0)).append("\n");
                sb.append("Name: ").append(c.getString(1)).append("\n");
                sb.append("Age: ").append(c.getString(2)).append("\n\n");
            }

            showMessage("All Records", sb.toString());
        });

        // UPDATE
        btnUpdate.setOnClickListener(v -> {
            boolean updated = db.updateData(
                    edtId.getText().toString(),
                    edtName.getText().toString(),
                    edtAge.getText().toString()
            );

            if (updated)
                showMessage("Success", "Data Updated");
            else
                showMessage("Error", "Update Failed");
        });

        // DELETE
        btnDelete.setOnClickListener(v -> {
            int deleted = db.deleteData(edtId.getText().toString());

            if (deleted > 0)
                showMessage("Success", "Data Deleted");
            else
                showMessage("Error", "Delete Failed");
        });
    }

    // SHOW ALERT DIALOG
    public void showMessage(String title, String msg) {
        new AlertDialog.Builder(this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(msg)
                .show();
    }
}
