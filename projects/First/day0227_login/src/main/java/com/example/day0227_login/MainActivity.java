package com.example.day0227_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editUserName;
    EditText editPassword;
    EditText editPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editUserName=findViewById(R.id.editUserName);
        editPassword=findViewById(R.id.editPassword);
        editPhone=findViewById(R.id.editPhone);
    }

    public void showMessage(View view) {
        Log.d("TAG", "showMessage: "+"用户名："+editUserName.getText().toString()+" 密码："+editPassword.getText().toString()+" 电话："+editPhone.getText().toString());
        String username=(editUserName.getText().toString());
        String pwd=(editPassword.getText().toString());
        if (username.equals("admin") && pwd.equals("123456"))
        {
            Log.d("TAG", "showMessage: "+"登录成功"+" 该用户手机为："+editPhone.getText().toString());
        }
        else
        {
            Log.d("TAG", "showMessage: "+"登录失败");
        }
    }
}
