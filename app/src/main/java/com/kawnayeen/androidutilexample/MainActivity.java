package com.kawnayeen.androidutilexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button testMultiple;
    Button testSingle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testMultiple = findViewById(R.id.testMultipleImage);
        testSingle = findViewById(R.id.testSingleImage);
        testMultiple.setOnClickListener(view -> startActivity(new Intent(this, MultipleImagePicking.class)));
        testSingle.setOnClickListener(view -> startActivity(new Intent(this, SingleImagePicking.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
