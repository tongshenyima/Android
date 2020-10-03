package net.jxvtc.newway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import net.jxvtc.newway.ui.MyDatePickerDialog;
import net.jxvtc.newway.ui.MyDialog;
import net.jxvtc.newway.ui.MyTimePickerDialog;

public class MainActivity extends AppCompatActivity implements MyDatePickerDialog.DateDialogListener , MyTimePickerDialog.TimerDialogListener {

//    对话框是提示用户做出决定或输入额外信息的小窗口。对话框不会填充屏幕，
//    通常用于需要用户采取行动才能继续执行的模式事件。
    // DialogFragment 与 AlertDialog 对象结合使用
    TextView tvDate,tvTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);
    }

    public void showDatePickerDialog(View view) {
        DialogFragment dialog=new MyDatePickerDialog();
        dialog.show(getSupportFragmentManager(),"datePicker");

    }

    @Override
    public void OnDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Toast.makeText(this, String.format("你选择的日期是%d年%d月%d日",year,month+1,dayOfMonth), Toast.LENGTH_SHORT).show();
        tvDate.setText(String.format("日期：%d年%d月%d日",year,month+1,dayOfMonth));
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(this, "时间："+hourOfDay+":"+minute, Toast.LENGTH_SHORT).show();
        tvTime.setText("时间："+hourOfDay+":"+minute);

    }

    public void showTimePickerDialog(View view) {
        DialogFragment dialog=new MyTimePickerDialog();
        dialog.show(getSupportFragmentManager(),"timePicker");
    }

    public void showCustomDialog(View view) {
        DialogFragment dialog=new MyDialog();
        dialog.show(getSupportFragmentManager(),"myDialog");
    }
}
