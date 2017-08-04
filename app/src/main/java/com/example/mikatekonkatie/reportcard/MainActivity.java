package com.example.mikatekonkatie.reportcard;


import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private StudentDB sd;
    EditText Name, studentNo, test1, test2;
    Button delete, add, update;
    TextView average;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sd = new StudentDB(this);
        Name = (EditText) findViewById(R.id.editName);
        studentNo = (EditText) findViewById(R.id.editstud);
        test1 = (EditText) findViewById(R.id.editTest1);
        test2 = (EditText) findViewById(R.id.editTest2);
        average = (TextView) findViewById(R.id.textView);
        delete = (Button) findViewById(R.id.button4);
        add = (Button) findViewById(R.id.button);
        update=(Button) findViewById(R.id.button);
    }

    public void addLeaner(View view) {
        int i = 0;

        String name = Name.getText().toString();
        String studentNu = studentNo.getText().toString();
        int mark = Integer.parseInt(test1.getText().toString());
        int mark2 = Integer.parseInt(test2.getText().toString());
        int avarage = Integer.parseInt(average.getText().toString());

        average.setText("Your percentage is " + avarage);
        avarage = (mark + mark2) / 2;


        Student student = new Student(i++, name, studentNu, mark, mark2, avarage);

        sd.addStudent(student);

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);

    }

    public void delete(View view) {
        String name = Name.getText().toString();
        sd.deleteStudent(name);

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public void update(View view) {
        EditText ed= (EditText) findViewById(R.id.editText);
        int colomnID= Integer.parseInt(ed.getText().toString());
        String name = Name.getText().toString();
        String studentNu = studentNo.getText().toString();
        int mark = Integer.parseInt(test1.getText().toString());
        int mark2 = Integer.parseInt(test2.getText().toString());
        int avarage = Integer.parseInt(average.getText().toString());


        avarage = (mark + mark2) / 2;
        sd.updateShow(colomnID,name,studentNu,mark,mark2,avarage);


        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}







