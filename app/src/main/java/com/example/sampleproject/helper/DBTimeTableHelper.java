package com.example.sampleproject.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBTimeTableHelper extends SQLiteOpenHelper {
    SQLiteDatabase db;

    private static final String DATABASE_NAME = "time_table.db";
    private static final String TABLE_TIMETABLE = "time_table";
    public static final String KEY_DAY = "day";
    public static final String KEY_PERIOD_BEGIN = "period_begin";
    public static final String KEY_PERIOD_END = "period_end";

    public static final String KEY_SUBJECT = "SUBJECT";
    public static final int DATABASE_VERSION = 1;
    public DBTimeTableHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("SQL", "SQLite dbhelper");
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqLite = "CREATE TABLE " + TABLE_TIMETABLE + "("
                + KEY_SUBJECT + " TEXT,"
                + KEY_DAY + " TEXT,"
                + KEY_PERIOD_BEGIN + " TEXT,"
                + KEY_PERIOD_END + " TEXT "
                + ")";
        sqLiteDatabase.execSQL(sqLite);
        Log.d("SQL", "SQLite onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sqLite = "DROP TABLE IF EXISTS " + TABLE_TIMETABLE;
        sqLiteDatabase.execSQL(sqLite);
        onCreate(sqLiteDatabase);
    }

    public void insertData(String day, String subject, String period_begin,String period_end) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_DAY, day);
        values.put(KEY_SUBJECT, subject);
        values.put(KEY_PERIOD_BEGIN, period_begin);
        values.put(KEY_PERIOD_END, period_end);

        db.insert(TABLE_TIMETABLE, null, values);
        db.close();
    }
    public void insert(String subject){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_SUBJECT, subject);
        db.insert(TABLE_TIMETABLE, null, values);
        db.close();
    }

//    public Boolean checkUser(String user){
//        if(KEY_USER_ACCOUNT == user)
//            return true;
//        else
//            return false;
//    }

//    public Boolean checkDay(String day){
//        if (day == KEY_MON || day == KEY_TUE || day == KEY_WED || day == KEY_THU || day == KEY_FRI || day == KEY_SAT || day == KEY_SUN)
//            return true;
//        else
//            return false;
//    }

//    public void createSubject(String subject){
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(KEY_SUBJECT, subject);
//        db.insert(TABLE_TIMETABLE, null, contentValues);
//    }


    public Cursor getData(String sql){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        return  cursor;
    }

//    public Cursor updateData(String sql){
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(sql, null);
//        return  cursor;
//    }

//    public boolean deleteData(Integer id){
//        db = this.getWritableDatabase();
//        return db.delete(TABLE_TIMETABLE, KEY_ID + "=" + id, null) > 0;
//    }
//
//    public boolean deleteAllData(){
//        db = this.getWritableDatabase();
//        return  db.delete(TABLE_TIMETABLE, null, null) > 0;
//    }
//
//    public Cursor getAllData(){
//        db = this.getWritableDatabase();
//        return null;
//        //
//    }
//
//    public Cursor getDataFromDay(String day){
//        db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_TIMETABLE + "WHERE " + KEY_DAY + " = " + day, new String[]{day});
//        return cursor;
//    }
//
//    public int updateStudent(Student student) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(KEY_NAME, student.getName());
//        values.put(KEY_CLASS, student.getClassName());
//        String whereClause = KEY_ID + "=?";
//        String[] whereArgs = {String.valueOf(student.getId())};
//        return db.update(TB_STUDENT, values, whereClause, whereArgs);
//    }
//    9

}
