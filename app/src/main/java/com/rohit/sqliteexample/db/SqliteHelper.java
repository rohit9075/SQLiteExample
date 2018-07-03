package com.rohit.sqliteexample.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import com.rohit.sqliteexample.model.Student;

import java.util.concurrent.locks.Condition;


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
     * This method will be used to insert student data in the database.
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


    /**
     * Squlite method to find the whether the user data is present in the daabase or not
     * @param email
     * @return
     */

    public boolean checkCandidate(String email, String password) {

        // array of columns to fetch
        String[] columns = {Const.STUDENT_EMAIL, Const.STUDENT_PASSWORD};
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = Const.STUDENT_EMAIL + " = ?" + " AND " + Const.STUDENT_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email,password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT student_email, student_password  FROM student WHERE student_email = 'abc@gmail.com' AND student_password = '123456';
         */
        Cursor cursor = db.query(Const.TABLE_NAME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

}
