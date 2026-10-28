package com.example.lapkaapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddReminderActivity extends AppCompatActivity {

    private EditText etReminderTitleInput, etReminderDateInput;
    private Button btnSaveReminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);

        // search elements by id
        etReminderTitleInput = findViewById(R.id.etReminderTitleInput);
        etReminderDateInput = findViewById(R.id.etReminderDateInput);
        btnSaveReminder = findViewById(R.id.btnSaveReminder);

        // сохранение задачи по клику
        btnSaveReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etReminderTitleInput.getText().toString();
                String date = etReminderDateInput.getText().toString();

                if (!title.isEmpty() && !date.isEmpty()) {
                    SharedPreferences prefs = getSharedPreferences("RemindersData", MODE_PRIVATE);
                    String currentReminders = prefs.getString("reminders", "");

                    // очистка стандартной заглушки
                    if (currentReminders.startsWith("Список дел пуст")) {
                        currentReminders = "";
                    }

                    // формирование новой строки списка
                    String newReminder = "• " + date + " — " + title + "\n";
                    String updatedReminders = currentReminders + newReminder;

                    // сохранение обновленного списка в память
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("reminders", updatedReminders);
                    editor.apply();
                }

                // возврат на экран списка
                finish();
            }
        });
    }
}
