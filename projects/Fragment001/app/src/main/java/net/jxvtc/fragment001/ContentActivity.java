package net.jxvtc.fragment001;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

public class ContentActivity extends AppCompatActivity {
    String content,title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        Intent intent = getIntent();
        title=intent.getStringExtra(NewsAdapter.TITLE);
        content=intent.getStringExtra(NewsAdapter.CONTENT);
        FragmentManager  manager= getSupportFragmentManager();
        ContentFragment fragment = (ContentFragment) manager.findFragmentById(R.id.frg_content);
        fragment.refreshData(title,content);

    }
}
