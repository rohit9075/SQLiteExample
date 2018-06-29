package com.rohit.sqliteexample.db;

import com.rohit.sqliteexample.db.Const;

/**
 * Class to provide constant string field of tables and delete table
 */

public class Tables {

    /**
     * String final field to create the student table
     */
    public static final String STUDENT_TABLE = "CREATE TABLE " + Const.TABLE_NAME + " ("+ Const.STUDENT_NAME + " TEXT " + " ," +
    Const.STUDENT_EMAIL + " TEXT PRIMARY KEY" + " ," + Const.STUDENT_MOBILE + " TEXT" + " ," +
    Const.STUDENT_PASSWORD + " TEXT" + ")";

    /**
     * Final string field to delete the student table.
     */
    public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " +Const.TABLE_NAME;
}
