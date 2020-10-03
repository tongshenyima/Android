package net.jxvtc.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] items;
    private boolean[] checkedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDialog(View view) {
        switch (view.getId())
        {
            case R.id.btnCommonDialog:
                showCommonDialog();
                break;
            case R.id.btnSingleChoiceDialog:
                showSingleChoiceDialog();
                break;
            case R.id.btnMutiChoiceDialog:
                showMultiChoiceDialog();
                break;
            case R.id.btnListDialog:
                showListDialog();
                break;
            case R.id.btnCustomDialog:
                showCustomDialog();
                break;

        }
    }

    /**
     * 选择自定义对话框
     */
    private void showCustomDialog() {
        MyDialog md = new MyDialog(this,R.style.mydialog);
        md.show();

    }

    /**
     * 选择列表对话框
     */
    private void showListDialog() {
        //TODO： 2、创建并显示列表对话框
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        //设置标题： 选择您心目中最不了起的抗击疫情人物
        builder.setTitle("选择您心目中最不了起的抗击疫情人物");
        // builder.setMessage("请选择符合要求的一项");
        //列表项："钟南山", "李兰娟", "其他"
        items = new String[]{"钟南山", "李兰娟", "其他"};
        //设置列表项，及列表项点击事件处理：以Toast方式显示 "  你心目中的偶像是："+选择项
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "你心目中的偶像是："+items[which], Toast.LENGTH_SHORT).show();
            }
        });
        //创建并显示对话框
        builder.create().show();

    }

    /**
     * 显示多选对话框
     */
    private void showMultiChoiceDialog() {
        //TODO: 4、创建和显示多选对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择多项");
        items=new String[]{"爱好1","爱好2","爱好3","爱好4"};
        checkedItems = new boolean[]{false, true, false, true};
        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                  checkedItems[which]=isChecked;
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StringBuffer sb=new StringBuffer();
                for (int i = 0; i < checkedItems.length; i++) {
                    if(checkedItems[i])
                    {
                        sb.append(items[i]).append(",");
                    }
                }
                if(sb.length()>1)
                {
                    sb.delete(sb.length()-1,sb.length());
                }
                String result=sb.toString();
                Toast.makeText(MainActivity.this, "爱好："+result, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }

    /**
     * 显示单选对话框
     */
    private void showSingleChoiceDialog() {
        //TODO: 3、创建与显示单选对话框
      AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("消息");
       // builder.setMessage("请选择符合要求的一项");
        items = new String[]{"选项A", "选项B", "选项C"};
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "你选择了"+items[which], Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.create().show();

    }

    /**
     * 显示普通对话框
     */
    private void showCommonDialog() {
        //TODO: 1、创建并显示普通对话框
        //创建对话框构建器对象
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //设置对话框标题
        builder.setTitle("系统消息")
                .setMessage("是否删除记录")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"已删除",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消",null).create().show();
        //设置对话框内容（显示的消息）：你确定要删除该条记录吗？

        //设置肯定按钮及相应的事件处理   确定   响应：以Toast方式显示输出：删除记录成功

        //设置否定按钮  取消

        //创建并显示对话框

    }
}
