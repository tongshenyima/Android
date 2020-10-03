package net.jxvtc.module001;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    RadioGroup group;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        group=findViewById(R.id.group);
        group.setOnCheckedChangeListener(this);
        fragment = new MessageFragment();
        loadFragment(fragment);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.rbMessage:
                //加载消息页
                fragment =new MessageFragment();
                break;
            case R.id.rbFolder:
                //加载文档页
                fragment =new FolderFragment();
                break;
            case R.id.rbOffice:
                //加载办事大厅
                fragment =new OfficeFragment();
                break;
            case R.id.rbAddress:
                //加载通讯录
                fragment =new AddressFragment();
                break;
            case R.id.rbFind:
                //加载发现
                fragment =new FindFragment();
                break;
        }
        if(fragment !=null)
        {
            loadFragment(fragment);
        }
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container,fragment)
                .commit();
    }
}
