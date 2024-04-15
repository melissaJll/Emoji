package com.example.emoji;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    //Calendario
    private EditText nomeTarefa;
    private Button selectDateButton, adicionarTarefa;
    private Calendar calendar;

    //horario
    private TextView horarioTextView , calendarioTextView;
    private Button definirHorarioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Menu Bottom
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



        //Nome da tarefa
        nomeTarefa = findViewById(R.id.nomeTarefa);


    //Calendario
        selectDateButton = findViewById(R.id.selecionarData);
        calendar = Calendar.getInstance();
        calendarioTextView = findViewById(R.id.calendarioTextView);


        selectDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(AdicionarTarefaActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                calendar.set(Calendar.YEAR, year);
                                calendar.set(Calendar.MONTH, month);
                                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                                String selectedDate = sdf.format(calendar.getTime());
                                Toast.makeText(AdicionarTarefaActivity.this, "Data selecionada: " + selectedDate, Toast.LENGTH_SHORT).show();
                                calendarioTextView.setText(selectedDate);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });

        //Horário
        horarioTextView = findViewById(R.id.horarioTextView);
        definirHorarioButton = findViewById(R.id.definirHorario);
        calendar = Calendar.getInstance();

        definirHorarioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(AdicionarTarefaActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                                calendar.set(Calendar.MINUTE, minute);

                                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
                                String selectedTime = sdf.format(calendar.getTime());
                                horarioTextView.setText(selectedTime);
                            }
                        }, hour, minute, true);
                timePickerDialog.show();
            }
        });



        // Banco de dados e inserir     SQLlite
        // findViewById(R.id.adicionaTarefa) chamar no onClick=adicionarTarefa

        Button adicionarTarefa = findViewById(R.id.adicionaTarefa);
        adicionarTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Abre ou cria o banco de dados
                    SQLiteDatabase bancoDados = openOrCreateDatabase("CheckList", MODE_PRIVATE, null);
                    bancoDados.execSQL("CREATE TABLE IF NOT EXISTS minhasTarefas (id INTEGER PRIMARY KEY AUTOINCREMENT, tarefa VARCHAR, data VARCHAR, horario VARCHAR)");

                    // Obtém a tarefa digitada
                    String novaTarefa = nomeTarefa.getText().toString();

                    // Obtém a data selecionada
                    String dataTarefa = calendarioTextView.getText().toString();

                    // Obtém o horário selecionado
                    String horarioTarefa = horarioTextView.getText().toString();

                    // Insere a nova tarefa com a data e horário fornecidos
                    bancoDados.execSQL("INSERT INTO minhasTarefas (tarefa, data, horario) VALUES('" + novaTarefa + "', '" + dataTarefa + "', '" + horarioTarefa + "')");

                    // Exibe as tarefas no Log
                    Cursor cursor = bancoDados.rawQuery("SELECT * FROM minhasTarefas", null);
                    int indiceColunaID = cursor.getColumnIndex("id");
                    int indiceColunaTarefa = cursor.getColumnIndex("tarefa");
                    int indiceColunaData = cursor.getColumnIndex("data");
                    int indiceColunaHorario = cursor.getColumnIndex("horario");

                    cursor.moveToFirst();
                    while (!cursor.isAfterLast()) {
                        Log.i("Logx", "ID: " + cursor.getString(indiceColunaID) + " - Tarefa: " + cursor.getString(indiceColunaTarefa) + " - Data: " + cursor.getString(indiceColunaData) + " - Horário: " + cursor.getString(indiceColunaHorario));
                        cursor.moveToNext();
                    }

                    cursor.close();

                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });



    }



}
