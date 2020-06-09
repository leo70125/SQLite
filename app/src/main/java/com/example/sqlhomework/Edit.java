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

public class Edit extends AppCompatActivity {
    private Button btn_delete,btn_edit;
    private TextView Tv_show;
    private EditText Ed_ID,Ed_name,Ed_score1,Ed_score2,Ed_score3;
    private SQLiteDatabase database;
    private DBHELPER dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Init();
        dbhelper = new DBHELPER(getApplicationContext());
        database = dbhelper.getWritableDatabase();
    }
    private void Init(){
        btn_delete = findViewById(R.id.btn_delete);
        btn_edit = findViewById(R.id.btn_edit);
        Tv_show = findViewById(R.id.Tv_show);
        Ed_ID = findViewById(R.id.Ed_ID);
        Ed_name = findViewById(R.id.Ed_name);
        Ed_score1 = findViewById(R.id.Ed_score1);
        Ed_score2 = findViewById(R.id.Ed_score2);
        Ed_score3 = findViewById(R.id.Ed_score3);
        btn_delete.setOnClickListener(onClickListener);
        btn_edit.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            long id ;
            int count = 8 ;
            ContentValues cv;
            switch (v.getId()){
                case R.id.btn_delete:
                    id = Integer.parseInt(Ed_ID.getText().toString());
                    count = database.delete(DBHELPER.TB,"_id=" + id,null);
                    Tv_show.setText("刪除記錄成功"+ count + "筆");
                    break;
                case R.id.btn_edit:
                    id = Integer.parseInt(Ed_ID.getText().toString());
                    cv = new ContentValues();
                    cv.put("_CH", Integer.parseInt(Ed_score1.getText().toString()));
                    cv.put("_EN", Integer.parseInt(Ed_score2.getText().toString()));
                    cv.put("_MA", Integer.parseInt(Ed_score3.getText().toString()));
                    count = database.update(DBHELPER.TB,cv,"_id=" + id ,null);
                    Tv_show.setText("更新紀錄成功" + count);
                    break;
            }

        }
    };
    @Override
    protected void onStop() {
        super.onStop();
        database.close();
    }
}
