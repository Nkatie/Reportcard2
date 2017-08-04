package com.example.mikatekonkatie.reportcard;

/**
 * Created by Mikateko (Nkatie) on 2017/07/25.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import java.util.ArrayList;


public class StudentDB extends SQLiteOpenHelper {
    private static final String TABLE_STUDENT = "student";
    private final String COLUMN_ID = "_id";
    private final String COLUMN_NAME = "name";
    private final String COLUMN_STUDENTNO = "studentNumber";
    private final String COLUMN_TEST1 = "test1";
    private final String COLUMN_TEST2 = "test2";
    private final String COLUMN_AVERAGE = "average";
    private final static String DATABASE_NAME = "student.db";
    private final static int DATABASE_VERSION = 1;
    private final String DATABASE_CREATE = "create table " + TABLE_STUDENT + "(" + COLUMN_ID + " integer primary key autoincrement," +
             COLUMN_NAME + " text not null," + COLUMN_STUDENTNO + " text not null,"  + COLUMN_TEST1 + " text not null, " + COLUMN_TEST2 + " text not null," + COLUMN_AVERAGE + " text not null);";
    Student student = new Student();
    private byte[] studentNumber;

    public StudentDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        onCreate(db);
    }
    public void addStudent(Student student){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(COLUMN_NAME,student.getName());
        contentValues.put(COLUMN_STUDENTNO,student.getStudentNo());
        contentValues.put(COLUMN_TEST1,student.getTest1());
        contentValues.put(COLUMN_TEST2,student.getTest2());
        contentValues.put(COLUMN_AVERAGE,student.getAverage());
        db.insert(TABLE_STUDENT,null,contentValues);

    }

    public ArrayList<String> getAllStudent(){
        ArrayList<String>students=new ArrayList<>();

        String selectQuery="SELECT * FROM "+ TABLE_STUDENT;
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()) {
            do {

                int id = cursor.getInt(0);
                String studName = cursor.getString(1);
                String studNum = cursor.getString(2);
                int studtest1 = cursor.getInt(3);
                int studtest2 = cursor.getInt(4);
                int studaverage = cursor.getInt(5);

                String display = id +  " Name  : " + studNum  +"  Student number: "+  studName +  "  Test 1  : " + studtest1  + "    Test 2  : " + studtest2 + " Average   : "+ studaverage;
                students.add(display);
                System.out.println("Name" + cursor.getString(1));
            }
            while (cursor.moveToNext());
        }
        return students;
    }

    public int deleteStudent(String x) {
        SQLiteDatabase db=this.getWritableDatabase();
        String[]whereArgs={x};
        int count=db.delete(this.TABLE_STUDENT,this.COLUMN_NAME+"=?",whereArgs);
        return count;

    }
    public void updateShow(long colomnID, String name, String studnu, int test1, int test2, int average) {
        ContentValues values=new ContentValues();

        SQLiteDatabase db=this.getWritableDatabase();
        //values.put(COLUMN_ID,id);
        values.put(COLUMN_NAME,name);
        values.put(COLUMN_STUDENTNO,studnu);
        values.put(COLUMN_TEST1,test1);
        values.put(COLUMN_TEST2,test2);
        values.put(COLUMN_AVERAGE,average);
        db.update(TABLE_STUDENT,values,COLUMN_ID + "=" + colomnID,null);
    }



}