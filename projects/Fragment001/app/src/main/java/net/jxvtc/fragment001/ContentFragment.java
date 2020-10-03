package net.jxvtc.fragment001;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {



    private TextView tv_title;
    private TextView tv_content;

    public ContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View  view = inflater.inflate(R.layout.fragment_content, container, false);
        tv_title = view.findViewById(R.id.tv_title);
        tv_content = view.findViewById(R.id.tv_content);
        return view;
    }
    public void refreshData(String title,String content)
    {
       if(tv_content!=null)
       {
           tv_content.setText(content);
       }
       if(tv_title!=null)
       {
           tv_title.setText(title);
       }
    }

}
