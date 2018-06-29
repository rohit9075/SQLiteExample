package com.rohit.sqliteexample.model;

/**
 * This is the model class to provide private field access in the application.
 */

public class Student {

    private String mStudentName;
    private String mStudentEmail;
    private String mStudentMobile;
    private String mStudentPassword;

    public String getmStudentName() {
        return mStudentName;
    }

    public void setmStudentName(String mStudentName) {
        this.mStudentName = mStudentName;
    }

    public String getmStudentEmail() {
        return mStudentEmail;
    }

    public void setmStudentEmail(String mStudentEmail) {
        this.mStudentEmail = mStudentEmail;
    }

    public String getmStudentMobile() {
        return mStudentMobile;
    }

    public void setmStudentMobile(String mStudentMobile) {
        this.mStudentMobile = mStudentMobile;
    }

    public String getmStudentPassword() {
        return mStudentPassword;
    }

    public void setmStudentPassword(String mStudentPassword) {
        this.mStudentPassword = mStudentPassword;
    }
}
