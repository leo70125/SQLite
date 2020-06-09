package com.example.sqlhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Add extends AppCompatActivity {
    private Button btn_add;
    private EditText Ed_ID,Ed_name,Ed_score1,Ed_score2,Ed_score3;
    private SQLiteDatabase database;
    private DBHELPER dbhelper;
    private TextView Tv_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        btn_add = findViewById(R.id.btn_add);
        Ed_ID = findViewById(R.id.Ed_ID);
        Ed_name = findViewById(R.id.Ed_name);
        Ed_score1 = findViewById(R.id.Ed_score1);
        Ed_score2 = findViewById(R.id.Ed_score2);
        Ed_score3 = findViewById(R.id.Ed_score3);
        Tv_show = findViewById(R.id.Tv_show);

        dbhelper = new DBHELPER(getApplicationContext());
        database = dbhelper.getWritableDatabase();


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id ;
                ContentValues cv;
                        cv = new ContentValues();
                        cv.put("_id", Integer.parseInt(Ed_ID.getText().toString()));
                        cv.put("_NAME",Ed_name.getText().toString());
                        cv.put("_CH", Integer.parseInt(Ed_score1.getText().toString()));
                        cv.put("_EN", Integer.parseInt(Ed_score2.getText().toString()));
                        cv.put("_MA", Integer.parseInt(Ed_score3.getText().toString()));

                        id = database.insert(DBHELPER.TB,null , cv);
                        Tv_show.setText("新增紀錄成功" + id + "筆");
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        database.close();
    }
}
