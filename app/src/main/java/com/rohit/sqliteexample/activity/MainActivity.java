package com.rohit.sqliteexample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rohit.sqliteexample.R;
import com.rohit.sqliteexample.db.SqliteHelper;
import com.rohit.sqliteexample.model.Student;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * private instance variable
     */
    private EditText mEdittextName, mEdittextEmail, mEdittextMobile, mEdittextPassword;
    Button mButtonRegister, mButtonGetData;
    String mStringName, mStringEmail, mStringMobile, mStringPassword;

    Student student = new Student();
    SqliteHelper sqliteHelper = new SqliteHelper(this);

    /**
     * This method will be called by the android framework (i.e. android system ) when activity will be launched.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Calling the method intiView to getting the reference of the views
         */
        intiView();

    }

    /**
     * This method will be called for getting the edittext data on the Register button click.
     */

    private void editTextValues() {
        mStringName = mEdittextName.getText().toString();
        mStringEmail = mEdittextEmail.getText().toString();
        mStringMobile = mEdittextMobile.getText().toString();
        mStringPassword = mEdittextPassword.getText().toString();
    }


    /**
     * This method will be called for getting the reference of the views.
     */

    private void intiView() {

        mEdittextName = findViewById(R.id.edittext_name);
        mEdittextEmail = findViewById(R.id.edittext_email);
        mEdittextMobile = findViewById(R.id.edittext_mobile);
        mEdittextPassword = findViewById(R.id.edittext_password);

        mButtonRegister = findViewById(R.id.button_register);

        mButtonGetData = findViewById(R.id.button_getData);
        mButtonGetData.setOnClickListener(this);
        mButtonRegister.setOnClickListener(this);

    }

    /**
     * This is the overridden method which is used to handle the click events
     *
     * @param v
     */

    @Override
    public void onClick(View v) {

        int id = v.getId();

        switch (id) {

            case R.id.button_getData:
                Intent mGetDataIntent = new Intent(this, StudentListActivity.class);
                startActivity(mGetDataIntent);
                break;

            case R.id.button_register:

                // calling the editTextValues method.
                editTextValues();

                // this method will be called for the setting the editext values to the student obj
                settingTheValuesToStudentObj();

                sqliteHelper.insert(student);
                // clearEdittext method call to clear the all the edittext.
                clearEdittext();

                break;
        }

    }

    /**
     * This method will be call for clear the EditText
     */
    private void clearEdittext() {
        mEdittextName.setText("");
        mEdittextEmail.setText("");
        mEdittextMobile.setText("");
        mEdittextPassword.setText("");
    }

    /**
     * This method will be call for setting the data to student object
     */
    private void settingTheValuesToStudentObj() {
        student.setmStudentName(mStringName);
        student.setmStudentEmail(mStringEmail);
        student.setmStudentMobile(mStringMobile);
        student.setmStudentPassword(mStringPassword);
    }

    public void CheckEamil(View view) {

        Boolean bool = sqliteHelper.checkCandidate("rohit9075@gmail.com","123456");

        if (bool == true){
            Toast.makeText(this, "user found", Toast.LENGTH_SHORT).show();
        }

    }
}
