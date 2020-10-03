package com.example.day0526;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String DATA = "data";
    EditText edtName,edtNo,edtAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edt_name);
        edtNo = findViewById(R.id.edt_no);
        edtAge = findViewById(R.id.edt_age);
    }
    public void read(View view){
        String content = new FileUtils().read(this,DATA);
        if (content!=null)
        {
            String[] contents =content.split(":");
            edtName.setText(contents[0]);
            edtNo.setText(contents[1]);
            edtAge.setText(contents[2]);
        }
    }
    public void save(View view){
        StringBuffer sb = new StringBuffer();
        sb.append(edtName.getText().toString()).append(":").append(edtNo.getText().toString()).append(":").append(edtAge.getText().toString());
        new FileUtils().write(this,sb.toString(),DATA);
    }
}
