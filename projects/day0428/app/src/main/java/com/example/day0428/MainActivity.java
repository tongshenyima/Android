package com.example.day0428;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.day0428.adapter.ContryAdapter;
import com.example.day0428.model.Country;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private ArrayList<Country> datas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDatas();//数据初始化
        recyclerView=findViewById(R.id.recycler_view);
        RecyclerView.Adapter adapter=
                new ContryAdapter(datas);
        recyclerView.setAdapter(adapter);
        //布局管理器
        //recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }
    private void getDatas() {
        datas = new ArrayList<>();
        datas.add(new Country(R.drawable.china,"中国"));
        datas.add(new Country(R.drawable.usa,"美国"));
        datas.add(new Country(R.drawable.germany,"德国"));
        datas.add(new Country(R.drawable.england,"英国"));
        datas.add(new Country( R.drawable.france,"法国"));

    }
}
