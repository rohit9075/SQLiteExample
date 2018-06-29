package com.rohit.sqliteexample.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import com.rohit.sqliteexample.model.Student;


/**
 * This is the Sqlite helper class.
 */

public class SqliteHelper extends SQLiteOpenHelper {

    private Context context;

    /**
     * SqliteHelper class constructor
     * @param context
     */
    public SqliteHelper(Context context) {
        super(context, Const.DATABASE, null, Const.DATABASE_VERSION);
        this.context = context;
    }

    /**
     * This method will be called to create the table once instance of the class is created.
     * @param db
     */

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Tables.STUDENT_TABLE);
    }

    /**
     * This method is called to update the database if version is updated it will delete the older database and
     * create new one.
     * @param db
     * @param oldVersion
     * @param newVersion
     */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

          db.execSQL(Tables.DELETE_TABLE);
          onCreate(db);

    }

    /**
     *
     * @param student
     */

    public void insert(Student student){

        // db instance to access the database
        SQLiteDatabase db = getWritableDatabase();

        // content value instance to passing the student data from object to table.
        ContentValues values = new ContentValues();

        // putting the student details in the value map form the student object

        values.put(Const.STUDENT_NAME, student.getmStudentName().trim());
        values.put(Const.STUDENT_EMAIL, student.getmStudentEmail().trim());
        values.put(Const.STUDENT_MOBILE, student.getmStudentMobile().trim());
        values.put(Const.STUDENT_PASSWORD , student.getmStudentPassword().trim());

        // db insert command
        db.insert(Const.TABLE_NAME,null,values);

        // showing the toast message to user on data submission
        Toast.makeText(context, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
    }

    /**
     * getData method to retrive the data from the student table
     * @return
     */


    public Cursor getData(){

        // db instance to perform the database read operation on the table.
        SQLiteDatabase db = getReadableDatabase();
        // Columns name to fetch the data form the student table.
        String [] columns = {Const.STUDENT_NAME,Const.STUDENT_EMAIL,Const.STUDENT_MOBILE,Const.STUDENT_PASSWORD};

        // getting the data from the table and saving it into the cursor object.
        Cursor c = db.query(Const.TABLE_NAME,columns,null,null,null,null,null);

        // Returning the cursor object to the calling method.
        return c;
    }

}
