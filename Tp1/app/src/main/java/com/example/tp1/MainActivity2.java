package com.example.tp1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    TextView fullName, email, phone, address, city;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fullName = findViewById(R.id.textFullName);
        email = findViewById(R.id.textEmail);
        phone = findViewById(R.id.textPhone);
        address = findViewById(R.id.textAddress);
        city = findViewById(R.id.textCity);

        // Get the data from Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            fullName.setText("Full Name: " + extras.getString("FULL_NAME"));
            email.setText("Email: " + extras.getString("EMAIL"));
            phone.setText("Phone: " + extras.getString("PHONE"));
            address.setText("Address: " + extras.getString("ADDRESS"));
            city.setText("City: " + extras.getString("CITY"));
        }
    }
}
