package com.example.persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    String name,surname,phonenumber,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button save = findViewById(R.id.savebuton);
        Button layout_list = findViewById(R.id.seecontact);

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

                    String data = name + ";" + surname + ";" + phonenumber + ";" + email + "\n";


                    // Obre l'arxiu per escriure
                    try {
                        String fileName = "contactes.txt";
                        String content = "Contingut que vols escriure a l'arxiu.";

                        FileOutputStream fos = openFileOutput(fileName, Context.MODE_APPEND);
                        fos.write(data.getBytes());
                        fos.close();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                    Toast.makeText(MainActivity.this, "Saved.", Toast.LENGTH_SHORT).show();
                    
                }
            }
        });
    layout_list.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            startActivity(intent);
        }
    });
    }



}