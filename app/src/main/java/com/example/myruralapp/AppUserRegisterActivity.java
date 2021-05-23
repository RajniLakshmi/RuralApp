package com.example.myruralapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class AppUserRegisterActivity extends AppCompatActivity {

 CircleImageView profileImg;
 EditText name, age,adharNo, mobileNo;
 RadioGroup genderGroup;
 RadioButton radioSex;
 CheckBox termsConditions;
 Button btn_verify;
 String mobileString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_user_register);

        profileImg = findViewById(R.id.profile_image);
        name = findViewById(R.id.app_user_name);
        age = findViewById(R.id.app_user_age);
        adharNo = findViewById(R.id.app_user_adhar);
        mobileNo = findViewById(R.id.app_user_mobile);
        termsConditions = findViewById(R.id.terms_conditions);

        genderGroup = findViewById(R.id.app_user_gender);

        int selectedId = genderGroup.getCheckedRadioButtonId();
        radioSex = findViewById(selectedId);

        btn_verify = findViewById(R.id.app_user_verify);

        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mobileString = mobileNo.getText().toString();
                validNo(mobileString);
                Intent intent = new Intent(AppUserRegisterActivity.this,VerifyPhoneActivity.class);
                intent.putExtra("mobile",mobileString);
                startActivity(intent);
                Toast.makeText(AppUserRegisterActivity.this,mobileString,Toast.LENGTH_LONG).show();

            }
        });

    }

    private void validNo(String mobileString){
        if(mobileString.isEmpty() || mobileString.length() < 10){
            mobileNo.setError("Enter a valid mobile");
            mobileNo.requestFocus();
        }
    }
}
