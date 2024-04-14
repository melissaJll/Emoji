package com.example.emoji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criando um Intent para iniciar a MainActivity
                /*O primeiro parâmetro LoginActivity.this especifica o contexto atual, onde é iniciado o Intent.
                O segundo parâmetro MainActivity.class é o q será iniciado*/
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                //  LoginActivity Finalizado para que o usuário não possa voltar para ela pressionando o botão de voltar
                finish();
            }
        });

    }

}
