package net.jxvtc.overview20200421;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String USER_NAME = "user_name";
    EditText edtUserName;
    Button btnRegSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
       btnRegSubmit = findViewById(R.id.btnRegSubmit);
       edtUserName=findViewById(R.id.edtUserName);
       btnRegSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //TODO：2、拿到当前界面中填写的用户名 （edtUserName中的输入）
        String username=edtUserName.getText().toString();
        //存储到Key为USER_NAME的键值对中
        Intent intent=new Intent();
        intent.putExtra(USER_NAME,username);
        //设置结果
        setResult(RESULT_OK,intent);
        //结束当前Activity，返回到前一个界面
        finish();
    }
}
