package com.example.day0611;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showResult(View view) {
        Gson gson = new Gson();
        String json=

    }

    private void parse() {
        //{"gender":true,"id":1,"sname":"严苛","sno":"100001"}
        //解析任务：json字符串---Java对象或Java对象数组
        String json = "{\"gender\":true,\"id\":1,\"sname\":\"严苛\",\"sno\":\"100001\"}";
        Gson gson = new GsonBuilder().create();
        Student student = gson.fromJson(json, Student.class);
        Log.d("TAG", "showResult: " + student.getSname() + ":" + student.getSno());
        json = "[{\"gender\":false,\"id\":1,\"sname\":\"严苛1\",\"sno\":\"100001\"},{\"gender\":false,\"id\":2,\"sname\":\"严苛2\",\"sno\":\"100002\"},{\"gender\":false,\"id\":3,\"sname\":\"严苛3\",\"sno\":\"100003\"},{\"gender\":false,\"id\":4,\"sname\":\"严苛4\",\"sno\":\"100004\"},{\"gender\":false,\"id\":5,\"sname\":\"严苛5\",\"sno\":\"100005\"},{\"gender\":false,\"id\":6,\"sname\":\"严苛6\",\"sno\":\"100006\"},{\"gender\":false,\"id\":7,\"sname\":\"严苛7\",\"sno\":\"100007\"},{\"gender\":false,\"id\":8,\"sname\":\"严苛8\",\"sno\":\"100008\"},{\"gender\":false,\"id\":9,\"sname\":\"严苛9\",\"sno\":\"100009\"},{\"gender\":false,\"id\":10,\"sname\":\"严苛10\",\"sno\":\"100010\"},{\"gender\":false,\"id\":11,\"sname\":\"严苛11\",\"sno\":\"100011\"},{\"gender\":true,\"id\":12,\"sname\":\"严苛12\",\"sno\":\"100012\"},{\"gender\":true,\"id\":13,\"sname\":\"严苛13\",\"sno\":\"100013\"},{\"gender\":true,\"id\":14,\"sname\":\"严苛14\",\"sno\":\"100014\"},{\"gender\":false,\"id\":15,\"sname\":\"严苛15\",\"sno\":\"100015\"},{\"gender\":false,\"id\":16,\"sname\":\"严苛16\",\"sno\":\"100016\"},{\"gender\":true,\"id\":17,\"sname\":\"严苛17\",\"sno\":\"100017\"},{\"gender\":false,\"id\":18,\"sname\":\"严苛18\",\"sno\":\"100018\"},{\"gender\":true,\"id\":19,\"sname\":\"严苛19\",\"sno\":\"100019\"},{\"gender\":true,\"id\":20,\"sname\":\"严苛20\",\"sno\":\"100020\"},{\"gender\":true,\"id\":21,\"sname\":\"严苛21\",\"sno\":\"100021\"},{\"gender\":true,\"id\":22,\"sname\":\"严苛22\",\"sno\":\"100022\"},{\"gender\":false,\"id\":23,\"sname\":\"严苛23\",\"sno\":\"100023\"},{\"gender\":true,\"id\":24,\"sname\":\"严苛24\",\"sno\":\"100024\"},{\"gender\":true,\"id\":25,\"sname\":\"严苛25\",\"sno\":\"100025\"},{\"gender\":false,\"id\":26,\"sname\":\"严苛26\",\"sno\":\"100026\"},{\"gender\":false,\"id\":27,\"sname\":\"严苛27\",\"sno\":\"100027\"},{\"gender\":false,\"id\":28,\"sname\":\"严苛28\",\"sno\":\"100028\"},{\"gender\":false,\"id\":29,\"sname\":\"严苛29\",\"sno\":\"100029\"},{\"gender\":false,\"id\":30,\"sname\":\"严苛30\",\"sno\":\"100030\"},{\"gender\":true,\"id\":31,\"sname\":\"严苛31\",\"sno\":\"100031\"},{\"gender\":false,\"id\":32,\"sname\":\"严苛32\",\"sno\":\"100032\"},{\"gender\":true,\"id\":33,\"sname\":\"严苛33\",\"sno\":\"100033\"},{\"gender\":true,\"id\":34,\"sname\":\"严苛34\",\"sno\":\"100034\"},{\"gender\":true,\"id\":35,\"sname\":\"严苛35\",\"sno\":\"100035\"},{\"gender\":true,\"id\":36,\"sname\":\"严苛36\",\"sno\":\"100036\"},{\"gender\":true,\"id\":37,\"sname\":\"严苛37\",\"sno\":\"100037\"},{\"gender\":true,\"id\":38,\"sname\":\"严苛38\",\"sno\":\"100038\"}]";
        List<Student> stus = gson.fromJson(json, new TypeToken<List<Student>>() {
        }.getType());
        Log.d("TAG", "showResult: " + stus.get(3).getSname() + ":" + stus.get(3).getSno());
    }

    private void genJosn() {
        Student stu = new Student();
        stu.setId(1);
        stu.setGender(true);
        stu.setSname("桐生一马");
        stu.setSno("1000001");
        Gson gson = new Gson();
        String result = gson.toJson(stu);
        List<Student> stus = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            stu = new Student();
            stu.setId(i);
            stu.setSname("桐生一马" + i);
            stu.setSno(String.format("100%03d", i));
            stu.setGender(Math.random() > 0.5 ? true : false);
            stus.add(stu);
        }
        result = gson.toJson(stus);
        Log.d("TAG", result);
    }
}
