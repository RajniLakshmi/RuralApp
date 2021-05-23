package com.example.myruralapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myruralapp.productModule.MainActivityProduct;

public class BuyerOptionsActivity extends AppCompatActivity {

    Button btn_find_ride, btn_find_delivery, btn_find_service, btn_find_product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_options);

        btn_find_ride = findViewById(R.id.btn_find_ride);
        btn_find_delivery = findViewById(R.id.btn_find_delivery);
        btn_find_service = findViewById(R.id.btn_find_service);
        btn_find_product = findViewById(R.id.btn_find_product);

        btn_find_ride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuyerOptionsActivity.this, CustomerSignUpActivity.class);
                startActivity(intent);
                finish();

            }
        });

        btn_find_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BuyerOptionsActivity.this, MainActivityProduct.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
