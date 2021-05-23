package com.example.myruralapp.notifyLearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myruralapp.R;

public class LoginActivity extends AppCompatActivity {

    private EditText mEmailField, mPasswordField;
    private Button mLoginBtn, mRegPageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmailField = findViewById(R.id.login_email);
        mPasswordField = findViewById(R.id.login_password);
        mLoginBtn = findViewById(R.id.login_btn);
        mRegPageBtn = findViewById(R.id.login_register_btn);

        mRegPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(regIntent);
            }
        });
    }
}
