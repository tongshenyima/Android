package net.jxvtc.task002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnBrowse, btnDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化组件
        initViews();
        //注册事件
        bindEvents();
    }

    private void bindEvents() {
        btnBrowse.setOnClickListener(this);
        btnDial.setOnClickListener(this);

    }

    private void initViews() {
        btnBrowse = findViewById(R.id.btnBrowse);
        btnDial = findViewById(R.id.btnDial);

    }

    @Override
    public void onClick(View v) {
        //点击事件处理方法
        Intent intent;
        Uri uri;
        switch (v.getId()) {
            case R.id.btnBrowse:
                // 2、打开浏览器，访问网址：
                uri = Uri.parse("http://www.bing.com");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.btnDial:
                // 3、拔打电话：13758085440
uri=Uri.parse("tel:13386631068");
intent=new Intent(Intent.ACTION_VIEW,uri);
startActivity(intent);
                break;
        }

    }
}
