package com.example.persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name,surname,phonenumber,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button save = findViewById(R.id.savebuton);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name1 = findViewById(R.id.insertname);
                EditText surname1 = findViewById(R.id.insertsurname);
                EditText phonenumber1 = findViewById(R.id.insertphonenumber);
                EditText mail1 = findViewById(R.id.insertmail);
                if (name1.getText().toString().equals("") ||
                        surname1.getText().toString().equals("") ||
                        phonenumber1.getText().toString().equals("") ||
                        mail1.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "You have to fill out all of text boxes to save.", Toast.LENGTH_SHORT).show();
                }else{
                    name = name1.getText().toString();
                    surname = surname1.getText().toString();
                    phonenumber = phonenumber1.getText().toString();
                    email = mail1.getText().toString();
                    name1.setText("");
                    surname1.setText("");
                    phonenumber1.setText("");
                    mail1.setText("");
                    Toast.makeText(MainActivity.this, "Saved.", Toast.LENGTH_SHORT).show();
                    
                }
            }
        });

    }
}