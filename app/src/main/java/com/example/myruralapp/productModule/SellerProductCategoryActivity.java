package com.example.myruralapp.productModule;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myruralapp.R;

public class SellerProductCategoryActivity extends AppCompatActivity implements View.OnClickListener {

     ImageView mGrocery, mToiletries, mMedicine, mHardware, mStationery, mRuralMart, mLocalProduce, mConfectionery, mBakery;

     Button logOutBtn, checkOrdersBtn, maintainProductsBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_product_category);

        logOutBtn = findViewById(R.id.admin_logout_btn);
        checkOrdersBtn = findViewById(R.id.check_orders_btn);
        maintainProductsBtn = findViewById(R.id.maintain_products);


        maintainProductsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SellerProductCategoryActivity.this, CustomerProductHome.class);
                intent.putExtra("Product Admin", "Product Admin");
                startActivity(intent);
            }
        });

        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SellerProductCategoryActivity.this, MainActivityProduct.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();

            }
        });

        checkOrdersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SellerProductCategoryActivity.this, ProductAdminNewOrdersActivity.class);
                startActivity(intent);

            }
        });
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
                Intent intentGrocery = new Intent(SellerProductCategoryActivity.this, SellerAddNewProduct.class);
                intentGrocery.putExtra("category", "grocery");
                startActivity(intentGrocery);
                break;
            case R.id.toiletries:
                Intent intentToiletries = new Intent(SellerProductCategoryActivity.this, SellerAddNewProduct.class);
                intentToiletries.putExtra("category", "toiletries");
                startActivity(intentToiletries);
                break;
            case R.id.medicine:
                Intent intentMedicine = new Intent(SellerProductCategoryActivity.this, SellerAddNewProduct.class);
                intentMedicine.putExtra("category", "medicine");
                startActivity(intentMedicine);
                break;
            case R.id.hardware:
                Intent intentHardware = new Intent(SellerProductCategoryActivity.this, SellerAddNewProduct.class);
                intentHardware.putExtra("category", "hardware");
                startActivity(intentHardware);
                break;
            case R.id.stationery:
                Intent intentStationery = new Intent(SellerProductCategoryActivity.this, SellerAddNewProduct.class);
                intentStationery.putExtra("category", "stationery");
                startActivity(intentStationery);
                break;
            case R.id.ruralMart:
                Intent intentRuralMart = new Intent(SellerProductCategoryActivity.this, SellerAddNewProduct.class);
                intentRuralMart.putExtra("category", "ruralMart");
                startActivity(intentRuralMart);
                break;
            case R.id.localProduce:
                Intent intentLocalProduce = new Intent(SellerProductCategoryActivity.this, SellerAddNewProduct.class);
                intentLocalProduce.putExtra("category", "localProduce");
                startActivity(intentLocalProduce);
                break;
            case R.id.confectionery:
                Intent intentConfectionery = new Intent(SellerProductCategoryActivity.this, SellerAddNewProduct.class);
                intentConfectionery.putExtra("category", "confectionery");
                startActivity(intentConfectionery);
                break;
            case R.id.bakery:
                Intent intentBakery = new Intent(SellerProductCategoryActivity.this, SellerAddNewProduct.class);
                intentBakery.putExtra("category", "bakery");
                startActivity(intentBakery);
                break;
        }
    }
}
