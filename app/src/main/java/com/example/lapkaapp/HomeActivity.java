package com.example.lapkaapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private Button btnAddPet;
    private TextView tvPetName, tvPetInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // поиск элементов по id
        btnAddPet = findViewById(R.id.btnAddPet);
        tvPetName = findViewById(R.id.tvPetName);
        tvPetInfo = findViewById(R.id.tvPetInfo);

        // переход на экран добавления питомца
        btnAddPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AddPetActivity.class);
                startActivity(intent);
            }
        });
        // переход в медкарту
        Button btnMedicalCard = findViewById(R.id.btnMedicalCard);
        btnMedicalCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MedicalCardActivity.class);
                startActivity(intent);
            }
        });
        // переход в напоминания
        Button btnReminders = findViewById(R.id.btnReminders);
        btnReminders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, RemindersActivity.class);
                startActivity(intent);
            }
        });
        // переход в рацион питания
        Button btnFeeding = findViewById(R.id.btnFeeding);
        btnFeeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, FeedingActivity.class);
                startActivity(intent);
            }
        });

        // переход в список покупок
        Button btnShopping = findViewById(R.id.btnShopping);
        btnShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ShoppingActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        // загрузка сохраненных данных питомца при открытии экрана
        SharedPreferences prefs = getSharedPreferences("PetData", MODE_PRIVATE);
        String name = prefs.getString("name", "Кличка питомца");
        String breed = prefs.getString("breed", "");
        String age = prefs.getString("age", "");

        tvPetName.setText(name);
        if (!breed.isEmpty() && !age.isEmpty()) {
            tvPetInfo.setText(breed + ", " + age);
        } else {
            tvPetInfo.setText("Порода, возраст");
        }
    }
}
