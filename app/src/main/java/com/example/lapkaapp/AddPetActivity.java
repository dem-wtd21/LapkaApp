package com.example.lapkaapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddPetActivity extends AppCompatActivity {

    private EditText etPetNameInput, etPetBreedInput, etPetAgeInput;
    private Button btnSavePet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pet);

        // поиск элементов по id
        etPetNameInput = findViewById(R.id.etPetNameInput);
        etPetBreedInput = findViewById(R.id.etPetBreedInput);
        etPetAgeInput = findViewById(R.id.etPetAgeInput);
        btnSavePet = findViewById(R.id.btnSavePet);

        // сохранение данных по клику на кнопку
        btnSavePet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etPetNameInput.getText().toString();
                String breed = etPetBreedInput.getText().toString();
                String age = etPetAgeInput.getText().toString();

                // запись данных в локальную память телефона
                SharedPreferences prefs = getSharedPreferences("PetData", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("name", name);
                editor.putString("breed", breed);
                editor.putString("age", age);
                editor.apply();

                // закрытие текущего экрана и возврат назад
                finish();
            }
        });
    }
}
