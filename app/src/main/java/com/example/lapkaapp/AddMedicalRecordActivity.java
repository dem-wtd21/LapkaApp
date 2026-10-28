package com.example.lapkaapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddMedicalRecordActivity extends AppCompatActivity {

    private EditText etRecordTitleInput, etRecordDateInput;
    private Button btnSaveRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medical_record);

        // поиск элементов по id
        etRecordTitleInput = findViewById(R.id.etRecordTitleInput);
        etRecordDateInput = findViewById(R.id.etRecordDateInput);
        btnSaveRecord = findViewById(R.id.btnSaveRecord);

        // сохранение записи по клику
        btnSaveRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etRecordTitleInput.getText().toString();
                String date = etRecordDateInput.getText().toString();

                if (!title.isEmpty() && !date.isEmpty()) {
                    SharedPreferences prefs = getSharedPreferences("MedicalData", MODE_PRIVATE);
                    String currentRecords = prefs.getString("records", "");

                    // если это первая запись, убираем стандартную заглушку
                    if (currentRecords.startsWith("Записей пока нет")) {
                        currentRecords = "";
                    }

                    // формирование новой строки списка
                    String newRecord = "• " + date + " — " + title + "\n";
                    String updatedRecords = currentRecords + newRecord;

                    // сохранение обновленного списка в память
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("records", updatedRecords);
                    editor.apply();
                }

                // возврат на предыдущий экран
                finish();
            }
        });
    }
}
