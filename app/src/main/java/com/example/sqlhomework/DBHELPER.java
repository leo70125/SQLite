package com.example.sqlhomework;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHELPER extends SQLiteOpenHelper {
    public final static int VS = 1;//版本
    public final static String DB = "MySQLiteDB3.db";//資料庫
    public final static String TB = "MySampleTable";//資料表

    public DBHELPER(Context context) {
        super(context, DB, null, VS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL = "CREATE TABLE IF NOT EXISTS " + TB + "( " +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "_NAME TEXT NOT NULL, " +
                "_CH INTEGER NOT NULL, " +
                "_EN INTEGER NOT NULL, " +
                "_MA INTEGER NOT NULL " +
                ");";
        db.execSQL(SQL);
        //    建立查詢方法select()，查詢單筆資料
        //    rawQuery完整輸入SQL語法實現資料查詢
//        public Cursor select(long id){
//            String select_text="SELECT * FROM "+TB+" WHERE "+"="+id;
//            Cursor cursor=db.rawQuery(select_text,null);
//            return cursor;
//        }
//
//        //    建立查詢方法select_all()，查詢所有資料
//        //    rawQuery完整輸入SQL語法實現資料查詢
//        public Cursor select_all(){
//            String select_text="SELECT * FROM "+TB;
//            Cursor cursor=db.rawQuery(select_text,null);
//            return cursor;
//        }
//    }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        final String SQL = "DROP TABLE " + TB;
        db.execSQL(SQL);
    }
}
