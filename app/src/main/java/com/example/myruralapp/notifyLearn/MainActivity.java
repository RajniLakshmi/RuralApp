package com.example.myruralapp.notifyLearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myruralapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    private TextView mProfileLabel, mUserLabel, mNotificationLabel;

    private ViewPager mMainPager;

    private PagerViewAdapter mPagerViewAdapter;

    private FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null){

            sendToLogin();
        }
    }

    private void sendToLogin() {

        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        mProfileLabel = findViewById(R.id.profileLabel);
        mUserLabel = findViewById(R.id.userLabel);
        mNotificationLabel = findViewById(R.id.notificationLabel);

        mMainPager = findViewById(R.id.mainPager);

        mPagerViewAdapter = new PagerViewAdapter(getSupportFragmentManager());
        mMainPager.setAdapter(mPagerViewAdapter);

        mProfileLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMainPager.setCurrentItem(0);
            }
        });

        mUserLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMainPager.setCurrentItem(1);
            }
        });

        mNotificationLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMainPager.setCurrentItem(2);
            }
        });

        mMainPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                changeTabs(position);

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void changeTabs(int position) {

        if (position == 0){

            mProfileLabel.setTextColor(getColor(R.color.textTabBright));
            mProfileLabel.setTextSize(22);

            mUserLabel.setTextColor(getColor(R.color.textTabLight));
            mUserLabel.setTextSize(16);

            mNotificationLabel.setTextColor(getColor(R.color.textTabLight));
            mNotificationLabel.setTextSize(16);
        }
        if (position == 1){
            mProfileLabel.setTextColor(getColor(R.color.textTabLight));
            mProfileLabel.setTextSize(16);

            mUserLabel.setTextColor(getColor(R.color.textTabBright));
            mUserLabel.setTextSize(22);

            mNotificationLabel.setTextColor(getColor(R.color.textTabLight));
            mNotificationLabel.setTextSize(16);
        }

        if (position == 2){
            mProfileLabel.setTextColor(getColor(R.color.textTabLight));
            mProfileLabel.setTextSize(16);

            mUserLabel.setTextColor(getColor(R.color.textTabLight));
            mUserLabel.setTextSize(16);

            mNotificationLabel.setTextColor(getColor(R.color.textTabBright));
            mNotificationLabel.setTextSize(22);
        }
    }
}



































