package net.jxvtc.module001;

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

    public void click(View view) {
        switch (view.getId())
        {
            case R.id.btnStatic:
                Intent intent=new Intent(this,StaticActivity.class);
                startActivity(intent);
                break;

            case R.id.btnCode:
                Intent intent1=new Intent(this,DynamicActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
