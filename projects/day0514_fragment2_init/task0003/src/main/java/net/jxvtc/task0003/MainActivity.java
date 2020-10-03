package net.jxvtc.task0003;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtNo;
    Button btnQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNo = findViewById(R.id.edtNo);
        btnQuery = findViewById(R.id.btnQuery);
        btnQuery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String strNo = edtNo.getText().toString();
        QueryFragment fragment = (QueryFragment) getSupportFragmentManager().findFragmentById(R.id.frg_query);
        fragment.setData(String.format("快递单号为%s的快件正在派送，请耐心等待！",strNo));
    }
}
