package com.example.module0012;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.btnFragA:
                AFragment fragA = new AFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.container, fragA).addToBackStack(null).commit();
                break;
            case R.id.btnFragB:
                BFragment fragB = new BFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.container, fragB).addToBackStack(null).commit();
                break;
        }
    }
}
