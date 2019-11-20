package com.example.scan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class coba extends AppCompatActivity {
String mmilik;
TextView tes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coba);
        Intent intent = getIntent();
        mmilik = intent.getStringExtra("jumlah");
        tes = (TextView) findViewById(R.id.tes);
        tes.setText(mmilik);
    }
}
