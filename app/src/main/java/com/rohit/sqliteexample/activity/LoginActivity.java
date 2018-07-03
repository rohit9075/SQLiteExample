package com.rohit.sqliteexample.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rohit.sqliteexample.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButtonLogin;

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
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        switch (id){
            case R.id.button:
                Intent mIntentRegisterActivity = new Intent(this, MainActivity.class);
                startActivity(mIntentRegisterActivity);
        }

    }
}
