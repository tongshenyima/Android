package net.jxvtc.task003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    public static final String COMPUTE_RESULT = "compute_result";
    TextView tvNo1, tvNo2;
    RadioGroup radioGroup;
    Button btnComputeAndReturn;
    double num1 = 1, num2 = 1;
    String resultReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        bindEvents();
    }

    private void bindEvents() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbAdd:
                        //加法操作
                        resultReturn = String.format("%f+%f=%f", num1, num2, (num1 + num2));
                        break;
                    case R.id.rbSub:
                        //减法操作
                        resultReturn = String.format("%f-%f=%f", num1, num2, (num1 - num2));
                        break;
                    case R.id.rbMul:
                        resultReturn = String.format("%.2f*%.2f=%.2f", num1, num2, (num1 * num2));
                        //乘法操作
                        break;
                    case R.id.rbDiv:
                        //除法操作
                        if (num2 != 0)
                            resultReturn = String.format("%f/%f=%f", num1, num2, (num1 / num2));
                        else
                            resultReturn = String.format("%f,除数不能为0", num1);
                        break;


                }
            }
        });

        btnComputeAndReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, resultReturn, Toast.LENGTH_SHORT).show();
                // 6、保存结果数据，并返回前一个界面
                Intent intent = new Intent();
                intent.putExtra(SecondActivity.COMPUTE_RESULT,resultReturn);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    private void initViews() {
        tvNo1 = findViewById(R.id.tvNo1);
        tvNo2 = findViewById(R.id.tvNo2);
        radioGroup = findViewById(R.id.group);
        btnComputeAndReturn = findViewById(R.id.btnComputeAndReturn);
        // 5、获取上一个Activity传递过来的数据，并显示在界面上
        Intent intent = getIntent();
        String str_num1 = intent.getStringExtra(MainActivity.KEY_NUM1);
        String str_num2 = intent.getStringExtra(MainActivity.KEY_NUM2);
        tvNo1.setText(str_num1);
        tvNo2.setText(str_num2);
        num1 = Double.parseDouble(str_num1);
        num2 = Double.parseDouble(str_num2);
    }
}
