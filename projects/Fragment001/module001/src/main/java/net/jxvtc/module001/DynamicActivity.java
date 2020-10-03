package net.jxvtc.module001;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DynamicActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnFragmentA,btnFragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
        btnFragmentA=findViewById(R.id.btnFragmentA);
        btnFragmentB=findViewById(R.id.btnFragmentB);
        btnFragmentA.setOnClickListener(this);
        btnFragmentB.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btnFragmentA:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container,new AFragment())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.btnFragmentB:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container,new BFragment())
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
