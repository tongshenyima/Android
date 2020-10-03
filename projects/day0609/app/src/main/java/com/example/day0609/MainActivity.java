package com.example.day0609;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class MainActivity extends AppCompatActivity {
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tvResult);
    }

    public void get(View view) {
        //访问网络是一个耗时操作，必须在新启一个线程中进行   利用线程池
        new Thread() {
            @Override
            public void run() {
                //真正线程执行的代码
                doGet();//Servlet
            }
        }.start();
    }

 


    private void doGet() {
        //抛异常
        HttpURLConnection conn = null;
        try {
            URL url = new URL("http://www.itcast.cn");
            //打开连接
            conn = (HttpURLConnection) url.openConnection();
            //设置连接的一些属性
            //请求方法 get,post
            //连接超时时间
            //读取输入流的最大等待时间
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(2000);
            conn.setReadTimeout(2000);
            //通过输入流获取网络响应数据    404   500 200  303
            int code = conn.getResponseCode();
            if (code == 200) {
                //读输入流
                final String result = getResult(conn.getInputStream());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvResult.setText(result);
                    }
                });
                Log.d("TAG", "doGet:" + result);
            }

        } catch (Exception ex) {

        } finally {
            if (conn != null) {
                conn.disconnect();
            }

        }


    }

    //读输入流==输出结果中
    private String getResult(InputStream inputStream) {
        //一行一行字符的读出  输入字节流---输入字符流---》缓存输入字符流
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,
                    "utf-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

        return sb.toString();
    }

    public void post(View view) {

    }
}

