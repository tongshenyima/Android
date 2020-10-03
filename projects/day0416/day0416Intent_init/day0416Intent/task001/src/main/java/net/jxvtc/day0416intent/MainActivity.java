package net.jxvtc.day0416intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toNext(View view) {
        //: 1、编写代码，实现从MainActivity跳转到SecondActivity功能
        //          并且排除运行过程中的错误（通过Logcat），确保运行正确
Intent intent=new Intent(this,SecondActivity.class);
startActivity(intent);


    }
}
