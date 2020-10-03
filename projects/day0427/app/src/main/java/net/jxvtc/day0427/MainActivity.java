package net.jxvtc.day0427;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import net.jxvtc.day0427.adapter.CountryAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//声明RecyclerView组件
    RecyclerView mRecyclerView;
    List<Item> datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=findViewById(R.id.my_recycler_view);//初始化组件（获得组件的引用）
        getDatas();//初始化数据
        CountryAdapter adapter=new CountryAdapter(this,datas);//数据适配器对象
        //指定适配器
        mRecyclerView.setAdapter(adapter);
        //指定布局管理器
     mRecyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.
               VERTICAL,false));
       // mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));

    }

    private void getDatas() {
        datas = new ArrayList<>();
        datas.add(new Item("中国", R.drawable.china));
        datas.add(new Item("美国", R.drawable.usa));
        datas.add(new Item("德国", R.drawable.germany));
        datas.add(new Item("英国", R.drawable.england));
        datas.add(new Item("法国", R.drawable.france));

    }
}
