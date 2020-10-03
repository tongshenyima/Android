package com.example.task001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
ImageView iv;
ProgressBar pb;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=findViewById(R.id.imageView);
        pb=findViewById(R.id.progressBar);
        tv = findViewById(R.id.textView);
        loadImage();

    }



    private void loadImage() {
        Thread thread=new Thread(){
            @Override
            public void run(){
                SystemClock.sleep(10000);
               runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       iv.setImageResource(R.drawable.im023);
                       pb.setVisibility(View.GONE);
                       tv.setVisibility(View.GONE);
                   }
               });
            }
        };
        thread.start();
    }
}
