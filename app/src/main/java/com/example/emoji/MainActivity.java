package com.example.emoji;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    Button btn_nova_tarefa;

    //ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //menu
        //binding = ActivityMainBinding.inflate(getLayoutInflater());
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        startActivity(new Intent(MainActivity.this, MainActivity.class));
                        return true;
                    case R.id.navigation_tasks:
                        startActivity(new Intent(MainActivity.this, AdicionarTarefaActivity.class));
                        return true;
                    case R.id.navigation_progresso:
                        startActivity(new Intent(MainActivity.this, ProgressoActivity.class));
                        return true;
                }
                return false;
            }
        });




        btn_nova_tarefa = findViewById(R.id.btn_nova_tarefa);

        btn_nova_tarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criando um Intent para iniciar a MainActivity
                /*O primeiro parâmetro LoginActivity.this especifica o contexto atual, onde é iniciado o Intent.
                O segundo parâmetro MainActivity.class é o q será iniciado*/
                Intent intent = new Intent(MainActivity.this, AdicionarTarefaActivity.class);
                startActivity(intent);
                //  LoginActivity Finalizado para que o usuário não possa voltar para ela pressionando o botão de voltar
                finish();
            }
        });
    }

        public void selecionadoBad(View view){
            this.opcaoSelecionada("bad");
        };

        public void selecionadoNormal(View view){
            this.opcaoSelecionada("normal");
        };

        public void selecionadoHappy(View view){
            this.opcaoSelecionada("happy");
        };

        public void opcaoSelecionada(String opcaoSelecionada){

            ImageView imagemResultado = findViewById(R.id.imagemResultado);

            switch (opcaoSelecionada){
                case "bad" :
                    imagemResultado.setImageResource(R.drawable.bad);
                    break;
                case "normal" :
                    imagemResultado.setImageResource(R.drawable.normal);
                    break;
                case "happy" :
                    imagemResultado.setImageResource(R.drawable.happy);
                    break;
            }

            System.out.println("Item selecionado: " + opcaoSelecionada);



    }
}
