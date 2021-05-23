package com.example.myruralapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.myruralapp.productModule.MainActivityProduct;
import com.example.myruralapp.productModule.SellerProductSignUpActivity;

public class MainActivity1 extends AppCompatActivity {
     Button mDriver, mCustomer, mProductCustomer,mProductSeller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        mDriver = findViewById(R.id.driver);
        mCustomer = findViewById(R.id.customer);
        mProductCustomer = findViewById(R.id.product_customer);
        mProductSeller = findViewById(R.id.product_seller);

        mDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity1.this, DriverSignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity1.this, CustomerSignUpActivity.class);
                startActivity(intent);
                finish();

            }
        });

        mProductCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity1.this, MainActivityProduct.class);
                startActivity(intent);
                finish();

            }
        });
        mProductSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity1.this, SellerProductSignUpActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}
