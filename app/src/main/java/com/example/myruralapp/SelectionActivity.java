package com.example.myruralapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectionActivity extends AppCompatActivity {

    Button buyer, seller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        buyer = findViewById(R.id.btn_buyer);
        seller = findViewById(R.id.btn_seller);

        buyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectionActivity.this, BuyerOptionsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        seller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectionActivity.this, CustomerSignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
