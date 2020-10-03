package com.example.regpager;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class NumAdapter extends PagerAdapter {
    public CharSequence getPageTitle(int posion){
        return "第"+(posion+1)+"页";
    }
    @Override
    public int getCount()
    {
        return 20;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        TextView tv = new TextView(container.getContext());
        //填充整个ViewPager
        ViewGroup.LayoutParams params=
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT );
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(120);//sp
        tv.setText((position+1)+"");
        container.addView(tv);//container就是viewpager对象
        return tv;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);//写死
    }
}
