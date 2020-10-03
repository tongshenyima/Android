package net.jxvtc.task003;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_NUM1 = "key_num1";
    public static final String KEY_NUM2 = "key_num2";
    private static final int REQUEST_COMPUTE = 1234;
    Button btnCompute;
    EditText edtNumber1, edtNumber2;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        bindEvents();
    }

    private void bindEvents() {
        btnCompute.setOnClickListener(this);
    }

    private void initViews() {
        btnCompute = findViewById(R.id.btnCompute);
        edtNumber1 = findViewById(R.id.etNumber1);
        edtNumber2 = findViewById(R.id.etNumber2);
        tvResult = findViewById(R.id.tvResult);
    }


    @Override
    public void onClick(View v) {
        //先验证两个操作数是否均有输入

        if (TextUtils.isEmpty(edtNumber1.getText().toString()) || TextUtils.isEmpty(edtNumber2.getText().toString())) {
            Toast.makeText(this, "请输入操作数1和操作数2", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, SecondActivity.class);
            // 4、把操作数1，操作数2，保存到Intent中，相应的键为KEY_NUM1,KEY_NUM2
            intent.putExtra(KEY_NUM1, edtNumber1.getText().toString());
            intent.putExtra(KEY_NUM2, edtNumber2.getText().toString());
            startActivityForResult(intent,REQUEST_COMPUTE);


        }
    }

    //TODO: 7、 重写onActivityResult方法，在该方法中获取第二个界面的返回数据，并加以显示


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK)
        {
            if (requestCode==MainActivity.REQUEST_COMPUTE)
            {
                String result = data.getStringExtra(SecondActivity.COMPUTE_RESULT);
                tvResult.setText(result);
            }
        }
    }
}
