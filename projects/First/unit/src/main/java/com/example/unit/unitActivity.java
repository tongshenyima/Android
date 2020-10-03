package com.example.unit;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
public class unitActivity extends AppCompatActivity {
    TextView tv;
    TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);
        tv=findViewById(R.id.textView);
        tv.setTextColor(Color.BLUE);
        tv2=findViewById(R.id.textView2);
        tv2.requestFocus();
    }
}
