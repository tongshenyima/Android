package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox cbOptionA,cbOptionB,cbOptionC,cbOptionD,cbOptionE,cbConfirm;
    Button btnSubmit;
    String[] options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        cbConfirm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                btnSubmit.setEnabled(isChecked);
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer sb=new StringBuffer();
                sb.append(cbOptionA.isChecked()?"A":"").append(cbOptionB.isChecked()?"B":"").append(cbOptionC.isChecked()?"C":"").append(cbOptionD.isChecked()?"D":"").append(cbOptionE.isChecked()?"E":"");
                String yourChoice=sb.toString();
                Toast.makeText(MainActivity.this, "你的答案是："+yourChoice,Toast.LENGTH_SHORT).show();
                String correct="BCD";
                boolean isTrue=false;
                isTrue=yourChoice.equals(correct);

                if (isTrue)
                {
                    Toast.makeText(MainActivity.this,"恭喜回答正确!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"回答错误!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void initViews() {
        options=getResources().getStringArray(R.array.options);
        cbConfirm=findViewById(R.id.cbConfirm);
        cbOptionA=findViewById(R.id.cbOptionA);
        cbOptionB=findViewById(R.id.cbOptionB);
        cbOptionC=findViewById(R.id.cbOptionC);
        cbOptionD=findViewById(R.id.cbOptionD);
        cbOptionE=findViewById(R.id.cbOptionE);
        cbOptionA.setText(options[0]);
        cbOptionB.setText(options[1]);
        cbOptionC.setText(options[2]);
        cbOptionD.setText(options[3]);
        cbOptionE.setText(options[4]);
        btnSubmit=findViewById(R.id.btnSubmit);
    }
}
