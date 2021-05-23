package com.example.myruralapp.productModule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myruralapp.R;
import com.example.myruralapp.productModule.Prevalent.Prevalent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class ConfirmFinalOrderActivityProduct extends AppCompatActivity {
    private EditText nameEditText, phoneEditText, addressEditText, townEditText;
    private Button confirmOrderButton;
    private String totalAmount = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_final_order_product);

        totalAmount = getIntent().getStringExtra("Total Price");
        Toast.makeText(this, "Cart Sub total: " + totalAmount, Toast.LENGTH_SHORT).show();

        confirmOrderButton = findViewById(R.id.confirm_final_order_btn);
        nameEditText = findViewById(R.id.shipment_name);
        phoneEditText = findViewById(R.id.shipment_phone_no);
        addressEditText = findViewById(R.id.shipment_address);
        townEditText = findViewById(R.id.shipment_town);

        confirmOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Check();

            }
        });
    }

    private void Check() {
        if (TextUtils.isEmpty(nameEditText.getText().toString())){
            Toast.makeText(this, "Enter your name", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(phoneEditText.getText().toString())){
            Toast.makeText(this, "Enter your number", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(addressEditText.getText().toString())){
            Toast.makeText(this, "Enter your Address", Toast.LENGTH_SHORT).show();
        }else  if (TextUtils.isEmpty(townEditText.getText().toString())){
            Toast.makeText(this, "Enter your town", Toast.LENGTH_SHORT).show();
        }else {
            confirmOrder();
        }
    }

    private void confirmOrder() {

        final String saveCurrentDate,saveCurrentTime;

        Calendar calForData = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd,yyyy");
        saveCurrentDate = currentDate.format(calForData.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calForData.getTime());

        final DatabaseReference orderRef = FirebaseDatabase.getInstance().getReference()
                .child("Product Orders")
                .child(Prevalent.currentOnlineUser.getPhone());

        HashMap<String, Object> orderMap = new HashMap<>();
        orderMap.put("totalAmount", totalAmount);
        orderMap.put("name", nameEditText.getText().toString());
        orderMap.put("phone", phoneEditText.getText().toString());
        orderMap.put("address", addressEditText.getText().toString());
        orderMap.put("town", townEditText.getText().toString());
        orderMap.put("date", saveCurrentDate);
        orderMap.put("time", saveCurrentTime);
        orderMap.put("state","not shipped");

        orderRef.updateChildren(orderMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    FirebaseDatabase.getInstance().getReference().child("Product Cart List")
                            .child("Product User View")
                            .child(Prevalent.currentOnlineUser.getPhone())
                            .removeValue()
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(ConfirmFinalOrderActivityProduct.this, "Order places Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(ConfirmFinalOrderActivityProduct.this,CustomerProductHome.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });
                }
            }
        });

    }
}
