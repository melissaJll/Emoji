package com.example.emoji;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AdicionarTarefaActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_tasks:
                        startActivity(new Intent(AdicionarTarefaActivity.this, AdicionarTarefaActivity.class));
                        return true;
                    case R.id.navigation_home:
                        startActivity(new Intent(AdicionarTarefaActivity.this, MainActivity.class));
                        return true;

                    case R.id.navigation_progresso:
                        startActivity(new Intent(AdicionarTarefaActivity.this, ProgressoActivity.class));
                        return true;
                }
                return false;
            }
        });


    }
}
