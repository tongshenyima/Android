package com.example.day0528;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String NAME = "name";
    public static final String NO = "no";
    public static final String AGE = "age";
    EditText edtName,edtNo,edtAge;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edt_name);
        edtNo = findViewById(R.id.edt_no);
        edtAge = findViewById(R.id.edt_age);
        preferences = getPreferences(MODE_PRIVATE);
    }

    public void read(View view) {
        String name=preferences.getString(NAME,"");
        String sno = preferences.getString(NO, "");
        int age = preferences.getInt(AGE, 0);
        edtName.setText(name);
        edtNo.setText(sno);
        edtAge.setText(age+"");
    }

    public void save(View view) {
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(NAME, edtName.getText().toString());
        edit.putString(NO, edtNo.getText().toString());
        edit.putInt(AGE, (Integer.parseInt(edtAge.getText().toString())));
        edit.apply();
    }
}
