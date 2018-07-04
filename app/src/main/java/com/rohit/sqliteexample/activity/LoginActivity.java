package com.rohit.sqliteexample.activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rohit.sqliteexample.R;
import com.rohit.sqliteexample.utils.InputValidation;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButtonLogin;
    InputValidation inputValidation;

    EditText mEdittextEamil;
    TextInputEditText mTextInputEdittextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        // initView method call
        initView();

    }

    /**
     * initView to resolve view id to get reference.
     */

    private void initView() {
        mButtonLogin = findViewById(R.id.button);
        mButtonLogin.setOnClickListener(this);
        inputValidation = new InputValidation(this);

        mEdittextEamil = findViewById(R.id.editText);
        mTextInputEdittextPassword = findViewById(R.id.password);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        switch (id){
            case R.id.button:

                // method call to check whether the input field is filled or empty
                if (inputValidation()) return;


                Intent mIntentRegisterActivity = new Intent(this, MainActivity.class);
                startActivity(mIntentRegisterActivity);
        }

    }



    /**
     * Input field validation method
     * @return
     */

    private boolean inputValidation() {
        if (!inputValidation.isEditTextFilled(mEdittextEamil,"Please enter the EmailId")){
            return true;
        }
        if (!inputValidation.isTextInputEditTextFilled(mTextInputEdittextPassword , "Please Enter the password")){
            return true;
        }
        return false;
    }


}
