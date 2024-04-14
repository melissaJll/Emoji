package com.example.emoji;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProgressoActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progresso);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_progresso:
                        startActivity(new Intent(ProgressoActivity.this, ProgressoActivity.class));
                        return true;
                    case R.id.navigation_home:
                        startActivity(new Intent(ProgressoActivity.this, MainActivity.class));
                        return true;
                    case R.id.navigation_tasks:
                        startActivity(new Intent(ProgressoActivity.this, AdicionarTarefaActivity.class));
                        return true;

                }
                return false;
            }
        });

    }
}
