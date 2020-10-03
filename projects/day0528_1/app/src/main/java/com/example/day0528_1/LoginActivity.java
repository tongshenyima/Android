package com.example.day0528_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String USERNAME ="username";
    public static final String PASSWORD =" password" ;
    public static final String AUTO_LOGIN =" auto_login" ;
    EditText edtUserName, edtPassword;
    CheckBox cbAuto ;
    Button btnLogin;
    private SharedPreferences sp;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState) ;
        setContentView (R.layout.activity_login) ;
        initViews() ;
        checkAutoLogin() ;
    }
    private void checkAutoLogin() {
        String username = sp.getString(USERNAME, "");
        String password = sp.getString(PASSWORD, "");
        boolean auto_login = sp.getBoolean(AUTO_LOGIN,false);
        if (login(username, password) && auto_login)
            gotoMain();
    }

    private void gotoMain() {
        Intent intent=new Intent ( this, MainActivity. class);
        startActivity(intent) ;
        finish() ;


    }

    private boolean login(String username, String password) {
        if (username.equals ("admin") &&password. equals("123456"))
            return true ;
        return false;

    }

    private void initViews() {
        sp =getSharedPreferences ( "LoginActivity.xml",MODE_PRIVATE) ;
        edtUserName= findViewById(R.id.edt_username) ;
        edtPassword=findViewById(R.id.edt_password) ;
        cbAuto=findViewById(R.id.cb_auto) ;
        btnLogin=findViewById(R.id.btn_login) ;
        btnLogin.setOnClickListener(this) ;

    }


    @Override
    public void onClick(View v) {
        String username = edtUserName.getText().toString();
        String password = edtPassword.getText().toString();
        boolean auto_login = cbAuto.isChecked();
        if (!login(username, password)) {
            Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences.Editor edit = sp.edit();
        if (auto_login) {
            edit.putString(USERNAME, username);
            edit.putString(PASSWORD, password);
            edit.putBoolean(AUTO_LOGIN, auto_login);
        } else {
            edit.remove(USERNAME);
            edit.remove(PASSWORD);
            edit.remove(AUTO_LOGIN);
        }
        edit.apply();
        gotoMain();
    }
}
