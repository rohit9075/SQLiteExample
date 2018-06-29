package com.rohit.sqliteexample.activity;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rohit.sqliteexample.R;
import com.rohit.sqliteexample.adapter.StudentAdapter;
import com.rohit.sqliteexample.db.SqliteHelper;
import com.rohit.sqliteexample.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentListActivity extends AppCompatActivity {

    /**
     * Instance variables
     */

    List<Student> studentList = new ArrayList<>();
    RecyclerView recyclerView;
    SqliteHelper sqliteHelper ;
    StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        sqliteHelper = new SqliteHelper(this);
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new StudentAdapter(studentList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // method call to access the data from the database
        getData();

    }

    /**
     * getData() method definition to get the data from database
     */

    public void getData() {

        Cursor c = sqliteHelper.getData();
        if (c.moveToFirst()) {
            do {

                Student stdObj = new Student();

                stdObj.setmStudentName(c.getString(0));
                stdObj.setmStudentEmail(c.getString(1));
                stdObj.setmStudentMobile(c.getString(2));
                stdObj.setmStudentPassword(c.getString(3));

                studentList.add(stdObj);

            } while (c.moveToNext());
        }
    }

}
