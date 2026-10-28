package com.example.lapkaapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MedicalCardActivity extends AppCompatActivity {

    private Button btnAddRecord;
    private TextView tvMedicalRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_card);

        // поиск элементов по id
        btnAddRecord = findViewById(R.id.btnAddRecord);
        tvMedicalRecords = findViewById(R.id.tvMedicalRecords);

        // переход на экран добавления новой записи
        btnAddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedicalCardActivity.this, AddMedicalRecordActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // загрузка сохраненных медицинских записей
        SharedPreferences prefs = getSharedPreferences("MedicalData", MODE_PRIVATE);
        String records = prefs.getString("records", "Записей пока нет. Нажмите добавить, чтобы внести прививку или осмотр.");
        tvMedicalRecords.setText(records);
    }
}
