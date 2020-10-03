package com.example.day0618;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    int choose=0;
    RadioGroup group;
    EditText edtInput;

    TextView tvResult=null;
    public static final String BASE_PATH = "http://japi.juhe.cn/charconvert/change.from";
    public static final String KEY = "2953b7925a7b88e1996051ff373e42d0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        bindEvents();
    }

    private void bindEvents() {
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //如何实现选择简体 choose=0 繁体 choose=1   火星文choose=2
                switch (checkedId) {
                    case R.id.rb_jt:
                        choose=0;
                        break;
                    case R.id.rb_ft:
                        choose=1;
                        break;
                    case R.id.rb_hxw:
                        choose=2;
                        break;
                }
            }
        });

    }

    private void initView() {
        group = findViewById(R.id.group);
        edtInput = findViewById(R.id.edtInput);
        tvResult = findViewById(R.id.tvResult);
    }

    public void query(View view) throws UnsupportedEncodingException {
        Toast.makeText(this,choose+"", Toast.LENGTH_SHORT).show();
        String urlPath=String.format("%s?text=%s&type=%d&key=%s",BASE_PATH, URLEncoder.encode(edtInput.getText().toString(),"utf-8"), choose, KEY);

    }
}
