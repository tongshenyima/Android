package net.jxvtc.task0003;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class QueryFragment extends Fragment {


    public QueryFragment() {
        // Required empty public constructor
    }
    public void setData(String content)
    {
        if(tvResult!=null)
        {
            tvResult.setText(content);
        }
    }

TextView tvResult;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_query, container, false);
        tvResult=root.findViewById(R.id.tvResult);
        return root;
    }

}
