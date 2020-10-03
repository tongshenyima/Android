package net.jxvtc.task005;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setDate(View view) {
        //设置时间
        SetDateFragment frg=new SetDateFragment();
        frg.show(getSupportFragmentManager(),null);
    }
}
