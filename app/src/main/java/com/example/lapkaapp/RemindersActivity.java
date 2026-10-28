package com.example.lapkaapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RemindersActivity extends AppCompatActivity {

    private Button btnAddReminder;
    private TextView tvRemindersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);

        // поиск элементов по id
        btnAddReminder = findViewById(R.id.btnAddReminder);
        tvRemindersList = findViewById(R.id.tvRemindersList);

        // переход на экран добавления задачи
        btnAddReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RemindersActivity.this, AddReminderActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // загрузка сохраненного списка дел
        SharedPreferences prefs = getSharedPreferences("RemindersData", MODE_PRIVATE);
        String reminders = prefs.getString("reminders", "Список дел пуст. Добавьте первую задачу по уходу за питомцем.");
        tvRemindersList.setText(reminders);
    }
}
