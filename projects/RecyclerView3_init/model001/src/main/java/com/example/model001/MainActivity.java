package com.example.model001;


import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    List<Book> lstBook;
    SwipeRefreshLayout swip;
    private RecyclerViewAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swip = findViewById(R.id.swipe);
        swip.setOnRefreshListener(this);
        lstBook = new ArrayList<>();
        lstBook.add(new Book("The Vegitarian", "Categorie Book", "Description book", R.drawable.thevigitarian));
        lstBook.add(new Book("The Wild Robot", "Categorie Book", "Description book", R.drawable.thewildrobot));
        lstBook.add(new Book("Maria Semples", "Categorie Book", "Description book", R.drawable.mariasemples));
        lstBook.add(new Book("The Martian", "Categorie Book", "Description book", R.drawable.themartian));
        lstBook.add(new Book("He Died with...", "Categorie Book", "Description book", R.drawable.hediedwith));
        lstBook.add(new Book("The Vegitarian", "Categorie Book", "Description book", R.drawable.thevigitarian));
        lstBook.add(new Book("The Wild Robot", "Categorie Book", "Description book", R.drawable.thewildrobot));
        lstBook.add(new Book("Maria Semples", "Categorie Book", "Description book", R.drawable.mariasemples));
        lstBook.add(new Book("The Martian", "Categorie Book", "Description book", R.drawable.themartian));
        lstBook.add(new Book("He Died with...", "Categorie Book", "Description book", R.drawable.hediedwith));
        lstBook.add(new Book("The Vegitarian", "Categorie Book", "Description book", R.drawable.thevigitarian));
        lstBook.add(new Book("The Wild Robot", "Categorie Book", "Description book", R.drawable.thewildrobot));
        lstBook.add(new Book("Maria Semples", "Categorie Book", "Description book", R.drawable.mariasemples));
        lstBook.add(new Book("The Martian", "Categorie Book", "Description book", R.drawable.themartian));
        lstBook.add(new Book("He Died with...", "Categorie Book", "Description book", R.drawable.hediedwith));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        myAdapter = new RecyclerViewAdapter(this, lstBook);
        myrv.setLayoutManager(new GridLayoutManager(this, 3));
        myrv.setAdapter(myAdapter);


    }

    @Override
    public void onRefresh() {
        //刷新业务
        //1、开启一个新的线程
        // 1.1 在线程中先休眠2秒，模拟访问网络需要一定的时间
        //1.2 在图书列表的起始添加1本图书，（从原有的图书列表中随机随一本）模拟
        //1.3 通过适配器，数据已发生变化，及时刷新的RecyclerView(界面）
        //1.4 刷新结束标置
        new Thread(){
            @Override
            public void run() {
                SystemClock.sleep(2000);
                randAddBook();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        myAdapter.notifyItemInserted(0);
                        swip.setRefreshing(false);
                    }
                });
            }
        }.start();
    }

    private void randAddBook() {
        Random random = new Random();
        int pos = random.nextInt(lstBook.size());
        Book newBook=lstBook.get(pos);
        lstBook.add(0,newBook);
    }
}
