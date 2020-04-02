package com.example.tareasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tareasqlite.database.DataBaseHelper;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataBase = new DataBaseHelper(this);
    }
}
