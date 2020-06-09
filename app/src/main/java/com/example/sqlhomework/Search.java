package com.example.sqlhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Search extends AppCompatActivity {
    private EditText Ed_ID;
    private Button btn_search;
    private TextView Tv_ID,Tv_show;
    private DBHELPER dbhelper;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        dbhelper = new DBHELPER (getApplicationContext());
        database = dbhelper.getWritableDatabase();

        Ed_ID = findViewById(R.id.Ed_ID);
        Tv_show = findViewById(R.id.Tv_show);
        btn_search = findViewById(R.id.btn_search);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Ed_ID.length()==0) {
                    sqlQuery("SELECT * FROM " + DBHELPER.TB);
                } else {
                    searchOneData("SELECT * FROM " + DBHELPER.TB + " WHERE _id='" + Ed_ID.getText().toString() + "'");

                }
            }
        });


}


    private void searchOneData(String sql){
        Cursor c = database.rawQuery(sql,null);
        String s = "";
//        Log.d("Search", "searchOneData, c.getCount = " + c.getCount());
//        Log.d("Search", "searchOneData, c.getColumnNames.length = " + c.getColumnNames().length);
        c.moveToFirst();

//        c.getColumnName();

        for (int i = 0; i < c.getColumnNames().length; i++) {
//            s += c.getColumnName(i);
            s += c.getColumnName(i) + ":" + c.getString(i) + "\n";
        }
//        Log.d("Search", "searchOneData, s = " + s);
        Tv_show.setText(s);


//
//        do {
//            Log.d("Search", "searchOneData, c.getString 0 = " + c.getString(0));
//            Log.d("Search", "searchOneData, c.getString 1 = " + c.getString(1));
//            Log.d("Search", "searchOneData, c.getString 2 = " + c.getString(2));
//            Log.d("Search", "searchOneData, c.getString 3 = " + c.getString(3));
//            Log.d("Search", "searchOneData, c.getString 4 = " + c.getString(4));
//        } while (c.moveToNext());

    }

    public void sqlQuery(String sql){
        String[] colNames;
        String str = "";
        Cursor c = database.rawQuery(sql,null);
        colNames = c.getColumnNames();
        for(int i = 0 ; i < colNames.length; i++){
            str += colNames[i] + "\t\t";
        }
        str += "\n";
        c.moveToFirst();
        for(int i =0; i < c.getCount(); i++) {
            str += c.getString(0) + "\t\t\t\t\t";
            str += c.getString(1) + "\t\t\t\t\t\t\t\t\t\t";
            str += c.getString(2) + "\t\t\t\t\t\t\t\t";
            str += c.getString(3) + "\t\t\t\t\t\t\t\t";
            str += c.getString(4) + "\t\t\t\t\t\n";
            c.moveToNext();
        }
        Tv_show.setText(str);
    }

    @Override
    protected void onStop() {
        super.onStop();
        database.close();
    }
}
