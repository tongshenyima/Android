package com.example.fragmentwork;

import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    RadioGroup group;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        group = findViewById(R.id.group);
        group.setOnCheckedChangeListener(this);
        fragment = new MessageFragment();
        loadFragment(fragment);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.rbMessage:
                fragment = new MessageFragment();
                break;
            case R.id.rbFolder:
                fragment = new FolderFragment();
                break;
            case R.id.rbOffice:
                fragment = new OfficeFragment();
                break;
            case R.id.rbAddress:
                fragment = new AddressFragment();
                break;
            case R.id.rbFind:
                fragment = new FindFragment();
                break;
        }
        if(fragment !=null){
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

