package com.example.navigationdemo;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        int id = item.getItemId();

                        if (id == R.id.nav_home) {
                            Toast.makeText(MainActivity.this, "Home Clicked", Toast.LENGTH_SHORT).show();
                        }
                        else if (id == R.id.nav_profile) {
                            Toast.makeText(MainActivity.this, "Profile Clicked", Toast.LENGTH_SHORT).show();
                        }
                        else if (id == R.id.nav_logout) {
                            Toast.makeText(MainActivity.this, "Logout Clicked", Toast.LENGTH_SHORT).show();
                        }

                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    }
                });
    }
}
