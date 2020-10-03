package net.jxvtc.overview20200421;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE = 2345;
    Button btnReg;
    EditText edtUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnReg = findViewById(R.id.btnReg);
        edtUserName = findViewById(R.id.edtUserName);
        btnReg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //TODO：1、跳转到注册页 采用startActivityForResult，请求码为REQUEST_CODE (2345)
        Intent intent = new Intent(this,RegActivity.class);
        startActivityForResult(intent,REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //TODO: 3、如果结果码为RESULT_OK,请求码为REQUEST_CODE,则处理结果（把用户在注册页面注册的用户名，显示在当前
        //页面的edtUserName输入框中
        if (resultCode==RESULT_OK)
            if (requestCode==REQUEST_CODE){
                String username=data.getStringExtra(RegActivity.USER_NAME);
                edtUserName.setText(username);
            }

        }
    }

