package com.example.nestedrecyclearviewrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.adaptorClasses.ChildAdaptor;
import com.example.adaptorClasses.ParentAdaptor;

public class Main3Activity extends AppCompatActivity {
    ImageView iv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        iv=findViewById(R.id.iv);
        Intent intent=getIntent();
        iv.setImageResource(intent.getIntExtra(MainActivity.IMAGE_KAY,-1));
    }
}