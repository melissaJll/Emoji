package com.example.emoji;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {


    public Button btn_nova_tarefa;
    public TextView dataHoje;

    //ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Data de Hoje
        dataHoje = findViewById(R.id.dataHoje);
        // método para formatar
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        SimpleDateFormat sdf = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("pt", "BR"));
        //retorna uma instância de Calendar que representa a data e hora atuais
        String dataAtualText = sdf.format(Calendar.getInstance().getTime());
        dataHoje.setText(dataAtualText);





        btn_nova_tarefa = findViewById(R.id.btn_nova_tarefa);


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
