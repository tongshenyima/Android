package net.jxvtc.module001;

import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    RadioGroup group;
    private Fragment fragment;
    String content="消息页";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        group = findViewById(R.id.group);
        group.setOnCheckedChangeListener(this);

        loadFragment(content);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.rbMessage:
                //加载消息页
                content ="消息页";
                break;
            case R.id.rbFolder:
                //加载文档页
                content ="文档页";
                break;
            case R.id.rbOffice:
                //加载办事大厅
                content ="办事大厅";
                break;
            case R.id.rbAddress:
                //加载通讯录
                content ="通讯录";
                break;
            case R.id.rbFind:
                //加载发现
                content ="发现";
                break;
        }


            loadFragment(content);

    }

    private void loadFragment(String content) {
        fragment = PageFragment.getInstance(content);
        getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, fragment)
                .commit();
    }
}
