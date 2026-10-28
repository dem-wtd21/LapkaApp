package com.example.lapkaapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class FeedingActivity extends AppCompatActivity {

    private EditText etFeedingPlan;
    private Button btnSaveFeeding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeding);

        // поиск элементов по id
        etFeedingPlan = findViewById(R.id.etFeedingPlan);
        btnSaveFeeding = findViewById(R.id.btnSaveFeeding);

        // загрузка сохраненного текста рациона
        SharedPreferences prefs = getSharedPreferences("FeedingData", MODE_PRIVATE);
        String savedPlan = prefs.getString("plan", "");
        etFeedingPlan.setText(savedPlan);

        // сохранение текста по клику на кнопку
        btnSaveFeeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String planText = etFeedingPlan.getText().toString();
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("plan", planText);
                editor.apply();
                finish();
            }
        });
    }
}
