package com.example.tp1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText fullName, email, phone, address;
    Spinner city;
    Button submitButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullName = findViewById(R.id.FullnameText);
        email = findViewById(R.id.EmailText);
        phone = findViewById(R.id.PhoneText);
        address = findViewById(R.id.Adresstext);
        city = findViewById(R.id.spinner);
        submitButton = findViewById(R.id.submitButton);

        // Setting up the Spinner with city list
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.city_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        city.setAdapter(adapter);

        // Handle city selection
        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedCity = parentView.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Selected: " + selectedCity, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("FULL_NAME", fullName.getText().toString());
                intent.putExtra("EMAIL", email.getText().toString());
                intent.putExtra("PHONE", phone.getText().toString());
                intent.putExtra("ADDRESS", address.getText().toString());
                intent.putExtra("CITY", city.getSelectedItem().toString());
                startActivity(intent);
            }
        });
    }
}
