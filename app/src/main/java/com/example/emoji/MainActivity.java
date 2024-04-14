package com.example.emoji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    Button btn_nova_tarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
