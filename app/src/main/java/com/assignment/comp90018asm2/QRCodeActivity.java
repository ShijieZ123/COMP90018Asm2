package com.assignment.comp90018asm2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QRCodeActivity extends AppCompatActivity {

    private Button GenerateBtn, ScanBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_r_code);
        GenerateBtn = findViewById(R.id.GenerateBtn);
        ScanBtn = findViewById(R.id.ScanBtn);
        GenerateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(QRCodeActivity.this, GeneratorActivity.class);
                startActivity(i);
            }
        });

        ScanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(QRCodeActivity.this, ScannerActivity.class);
                startActivity(i);
            }
        });
    }
}