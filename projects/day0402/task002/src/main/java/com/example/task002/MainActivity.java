package com.example.task002;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    ProgressBar pb;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        bindEvents();
    }

    private void bindEvents() {
        btn.setOnClickListener(this);
    }

    private void initViews() {
        btn = findViewById(R.id.button);
        pb = findViewById(R.id.progressBar);
        tv = findViewById(R.id.textView);
    }
int current=0;
    @Override
    public void onClick(View v) {
        final Timer timer=new Timer();
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pb.setProgress(current);
                        tv.setText(String.format("%d%%",current));
                        if (current>=100)
                        {
                            timer.cancel();return;
                        }
                        current++;
                    }
                });
            }
        };
        timer.schedule(task,0,200);
    }
}
