package com.example.sqlhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button bt_add,bt_edit,bt_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_add = findViewById(R.id.bt_add);
        bt_edit = findViewById(R.id.bt_edit);
        bt_search = findViewById(R.id.bt_search);

        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Add.class);
                startActivity(intent);
            }
        });

        bt_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Edit.class);
                startActivity(intent);
            }
        });

        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Search.class);
                startActivity(intent);
            }
        });
    }
}
