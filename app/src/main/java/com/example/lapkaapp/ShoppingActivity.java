package com.example.lapkaapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ShoppingActivity extends AppCompatActivity {

    private EditText etShoppingInput;
    private Button btnAddShopping;
    private TextView tvShoppingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        // поиск элементов по id
        etShoppingInput = findViewById(R.id.etShoppingInput);
        btnAddShopping = findViewById(R.id.btnAddShopping);
        tvShoppingList = findViewById(R.id.tvShoppingList);

        // загрузка сохраненного списка покупок
        SharedPreferences prefs = getSharedPreferences("ShoppingData", MODE_PRIVATE);
        String savedList = prefs.getString("list", "Список покупок пуст. Впишите товар выше.");
        tvShoppingList.setText(savedList);

        // добавление нового товара по клику
        btnAddShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = etShoppingInput.getText().toString().trim();

                if (!item.isEmpty()) {
                    String currentList = prefs.getString("list", "");

                    // очистка стандартной заглушки
                    if (currentList.startsWith("Список покупок пуст")) {
                        currentList = "";
                    }

                    // формирование строки с маркером чекбокса
                    String newItem = "[ ] " + item + "\n";
                    String updatedList = currentList + newItem;

                    // сохранение в память телефона
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("list", updatedList);
                    editor.apply();

                    // обновление текста на экране и очистка поля ввода
                    tvShoppingList.setText(updatedList);
                    etShoppingInput.setText("");
                }
            }
        });
    }
}
