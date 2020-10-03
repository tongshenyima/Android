package com.example.day0604;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.day0604.user.AppDatabase;
import com.example.day0604.user.User;
import com.example.day0604.user.UserDao;

import java.util.List;

import javax.xml.transform.sax.TemplatesHandler;

import kotlin.collections.unsigned.UArraysKt;

public class MainActivity extends AppCompatActivity {
private AppDatabase db;
    private UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"database-name").build();
        userDao = db.userDao();
    }

    public void insert(View view) {
        new Thread(){
            @Override
            public void run() {
                User user = new User();
                user.firstName = "毛";
                user.lastName = "星慧";
                userDao.insertAll(user);
            }
        }.start();
    }

    public void query(View view) {
        new Thread(){
            @Override
            public void run() {
                List<User> users=userDao.getAll();
                for (User user : users) {
                    Log.d("TAG", String.format("query:user[%d,%s,%s]", user.uid));
                }
            }
        }.start();
    }

    public void delete(View view) {
        new Thread(){
            @Override
            public void run() {
                User user=userDao.findByName("毛","星慧");
                userDao.delete(user);

            }
        }.start();
    }

    public void update(View view) {
        new Thread(){
            @Override
            public void run() {
                User user = userDao.findByName("毛", "星慧");
                user.lastName = "星慧";
                userDao.update(user);
            }
        }.start();
    }
}
