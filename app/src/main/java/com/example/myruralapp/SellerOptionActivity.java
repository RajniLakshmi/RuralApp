package com.example.myruralapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myruralapp.productModule.MainActivityProduct;
import com.example.myruralapp.productModule.SellerProductSignUpActivity;

public class SellerOptionActivity extends AppCompatActivity {

    Button btn_offer_ride, btn_offer_delivery, btn_offer_service, btn_offer_product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_option);

        btn_offer_ride = findViewById(R.id.btn_offer_ride);
        btn_offer_delivery = findViewById(R.id.btn_offer_delivery);
        btn_offer_service = findViewById(R.id.btn_offer_service);
        btn_offer_product = findViewById(R.id.btn_offer_product);

        btn_offer_ride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SellerOptionActivity.this, DriverSignUpActivity.class);
                startActivity(intent);
                finish();

            }
        });

        btn_offer_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerOptionActivity.this, SellerProductSignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
