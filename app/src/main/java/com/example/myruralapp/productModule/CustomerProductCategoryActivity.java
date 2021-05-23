package com.example.myruralapp.productModule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myruralapp.R;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CustomerProductCategoryActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mGrocery, mToiletries, mMedicine, mHardware, mStationery, mRuralMart, mLocalProduce, mConfectionery, mBakery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_product_category);

        mGrocery = findViewById(R.id.grocery);
        mToiletries = findViewById(R.id.toiletries);
        mMedicine = findViewById(R.id.medicine);
        mHardware = findViewById(R.id.hardware);
        mStationery = findViewById(R.id.stationery);
        mRuralMart = findViewById(R.id.ruralMart);
        mLocalProduce = findViewById(R.id.localProduce);
        mConfectionery = findViewById(R.id.confectionery);
        mBakery = findViewById(R.id.bakery);

        mGrocery.setOnClickListener(this);
        mToiletries.setOnClickListener(this);
        mMedicine.setOnClickListener(this);
        mHardware.setOnClickListener(this);
        mStationery.setOnClickListener(this);
        mRuralMart.setOnClickListener(this);
        mLocalProduce.setOnClickListener(this);
        mConfectionery.setOnClickListener(this);
        mBakery.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.grocery:
                Intent intentGrocery = new Intent(CustomerProductCategoryActivity.this, ShopsNearMeActivity.class);
               // intentGrocery.putExtra("category", "grocery");
                startActivity(intentGrocery);
                break;
            case R.id.toiletries:
                Intent intentToiletries = new Intent(CustomerProductCategoryActivity.this, ShopsNearMeActivity.class);
              //  intentToiletries.putExtra("category", "toiletries");
                startActivity(intentToiletries);
                break;
            case R.id.medicine:
                Intent intentMedicine = new Intent(CustomerProductCategoryActivity.this, ShopsNearMeActivity.class);
                //intentMedicine.putExtra("category", "medicine");
                startActivity(intentMedicine);
                break;
            case R.id.hardware:
                Intent intentHardware = new Intent(CustomerProductCategoryActivity.this, ShopsNearMeActivity.class);
               // intentHardware.putExtra("category", "hardware");
                startActivity(intentHardware);
                break;
            case R.id.stationery:
                Intent intentStationery = new Intent(CustomerProductCategoryActivity.this, ShopsNearMeActivity.class);
               // intentStationery.putExtra("category", "stationery");
                startActivity(intentStationery);
                break;
            case R.id.ruralMart:
                Intent intentRuralMart = new Intent(CustomerProductCategoryActivity.this, ShopsNearMeActivity.class);
               // intentRuralMart.putExtra("category", "ruralMart");
                startActivity(intentRuralMart);
                break;
            case R.id.localProduce:
                Intent intentLocalProduce = new Intent(CustomerProductCategoryActivity.this, ShopsNearMeActivity.class);
               // intentLocalProduce.putExtra("category", "localProduce");
                startActivity(intentLocalProduce);
                break;
            case R.id.confectionery:
                Intent intentConfectionery = new Intent(CustomerProductCategoryActivity.this, ShopsNearMeActivity.class);
               // intentConfectionery.putExtra("category", "confectionery");
                startActivity(intentConfectionery);
                break;
            case R.id.bakery:
                Intent intentBakery = new Intent(CustomerProductCategoryActivity.this, ShopsNearMeActivity.class);
                //intentBakery.putExtra("category", "bakery");
                startActivity(intentBakery);
                break;
        }
    }
}
