package com.example.day0616;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpUtils {

    /**
     * get请求
     * @param urlPath  请求地址 如:http://www.baidu.com  http://www.baidu.com?s=java
     * @param callback 响应回调
     */
    public static  void sendOkHttpGet(String urlPath, Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        Request request=new Request.Builder()
                .url(urlPath)
                .build();
        //enqueque方法：异步方法，callback方法运行在新的线程中
        client.newCall(request).enqueue(callback);
    }

    /**
     * 功能：处理POST请求
     * @param urlPath  请求url
     * @param requestBody  请求消息体
     * 示例：http://www.baidu.com?s=java
     * 则urlPath: http://www.baidu.com
     * RequestBody body=new FormBody.Builder()
     *                 .add("word", "一鼓作气")
     *                 .add("key",API_KEY)
     *                 .build();
     * @param callback  结果回调
     */
    public static  void sendOkHttpPost(String urlPath, RequestBody requestBody,Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        Request request=new Request.Builder()
                .url(urlPath).post(requestBody)
                .build();
        client.newCall(request).enqueue(callback);

    }

}
