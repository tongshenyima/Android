package net.jxvtc.task001;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HelloFragment extends Fragment {


    public HelloFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_hello,container,false);
        Button btnSavHello=root.findViewById(R.id.btnSayHello);
        btnSavHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentActivity activity = getActivity();
                TextView tvResult=activity.findViewById(R.id.tvResult);
                tvResult.setText("我来自于Fragment");
            }
        });
        return root;
    }

}
