package com.example.day0616;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    EditText edtPhone;
    TextView tvProvince;
    TextView tvCity;
    TextView tvCompany;
    public static final String KEY = "c277a3e018fbad142de1a359e2b909c4";
    public static final String BASE_URL = "http://apis.juhe.cn/mobile/get";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPhone = findViewById(R.id.edtPhone);
        tvCity = findViewById(R.id.tvCity);
        tvCompany = findViewById(R.id.tvCompany);
        tvProvince = findViewById(R.id.tvProvince);
    }

    public void query(View view) {
        String phone = edtPhone.getText().toString();
        String urlPath = String.format("%s?Phone=%s&key=%s", BASE_URL, phone, KEY);
        HttpUtils.sendOkHttpGet(urlPath, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String strJson = response.body().string();
                Log.d("TAG", "onResponse:" + strJson);
            }
        });
    }
    private void jsonParse(String strJson){
        Gson gson = new Gson();
        final PhoneResult result=gson.fromJson(strJson,)
    }
}
