package net.jxvtc.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private SQLiteDatabase database;
    TextView tvResult;
    EditText edt_sno, edt_name;
    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tv_result);
        group = findViewById(R.id.group);
        edt_name = findViewById(R.id.edt_name);
        edt_sno = findViewById(R.id.edt_no);
        group.setOnCheckedChangeListener(this);
        CustomSqlHelper helper = new CustomSqlHelper(this, "exam.db", null, 4);
        database = helper.getWritableDatabase();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (database != null)
            database.close();
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.btn_insert:
                save();
                break;
            case R.id.btn_query:
                query();
                break;
            case R.id.btn_modify:
                modify();
                break;
            case R.id.btn_delete:
                delete();
                break;
        }
    }

    String sex = "";

    private void query() {
        Cursor cursor = database.query("student", new String[]{"sno", "sname", "sex"}, null, null, null, null, null);
        StringBuffer sb = new StringBuffer();
        String sno = "";
        String sname = "";

        while (cursor.moveToNext()) {
            sno = cursor.getString(cursor.getColumnIndex("sno"));
            sname = cursor.getString(cursor.getColumnIndex("sname"));
            sex = cursor.getString(cursor.getColumnIndex("sex"));
            sb.append(sno).append("\t\t\t").append(sname).append("\t\t\t").append(sex).append("\r\n");
        }
        String result = sb.toString();
        tvResult.setText(result);
        cursor.close();
    }

    private void modify() {
        ContentValues cv = new ContentValues();
        cv.put("sno", edt_sno.getText().toString());
        cv.put("sname", edt_name.getText().toString());
        cv.put("sex", sex);

        database.update("studnet", cv, "son=?", new String[]{edt_sno.getText().toString()});
        query();
    }

    private void delete() {
        database.delete("student", " sno=?", new String[]{edt_sno.getText().toString()});
        query();
    }

    private void save() {
        ContentValues cv = new ContentValues();
        cv.put(" sno", edt_sno.getText().toString());
        cv.put(" sname", edt_name.getText().toString());
        cv.put(" sex", sex);
        database.insert("student", null, cv);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_male:
                sex = "男";
                break;
            case R.id.rb_female:
                sex = "女";
                break;

        }
    }
}