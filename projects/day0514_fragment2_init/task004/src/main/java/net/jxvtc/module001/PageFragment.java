package net.jxvtc.module001;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {


    public static final String CONTENT = "Content";


    public PageFragment() {
        // Required empty public constructor
    }
public static PageFragment getInstance(String content)
{
    PageFragment fragment=new PageFragment();
    Bundle bundle=new Bundle();
    bundle.putString(CONTENT,content);
    fragment.setArguments(bundle);
    return fragment;
}



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_page, container, false);
        Bundle bundle=getArguments();
        String content = bundle.getString(CONTENT, "消息页");
        TextView textView = root.findViewById(R.id.tvContent);
        textView.setText(content);
        return root;
    }

}
