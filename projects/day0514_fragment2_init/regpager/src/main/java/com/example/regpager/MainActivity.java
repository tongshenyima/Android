package com.example.regpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    ViewPager vp;
    NumAdapter adapter;
    Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = findViewById(R.id.vp_num);
        adapter=new NumAdapter();
        vp.setAdapter(adapter);
        btnStart = findViewById(R.id.btnStart);
        vp.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.i("TAG",String.format("position:%d,offest:%f,pixels:%d",position,positionOffset,positionOffsetPixels));
    }

    @Override
    public void onPageSelected(int position) {
        if (position==19){
            btnStart.setVisibility(View.VISIBLE);
        }
        else
        {
            btnStart.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
