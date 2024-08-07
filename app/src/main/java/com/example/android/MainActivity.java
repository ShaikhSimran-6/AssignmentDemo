package com.example.android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button view_products_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        view_products_btn = findViewById(R.id.view_prodcut_btn);

        view_products_btn.setOnClickListener(view -> {

            Intent i = new Intent(MainActivity.this, ProductListActivity.class);
            startActivity(i);

        });

    }
}