package net.jxvtc.task002;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ComputeFragment extends Fragment implements View.OnClickListener {

Button btnAdd;
EditText edtNum1,edtNum2;
    public ComputeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_compute, container, false);
        btnAdd=root.findViewById(R.id.btnAdd);
        edtNum1=root.findViewById(R.id.edtNum1);
        edtNum2=root.findViewById(R.id.edtNum2);
        btnAdd.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        double num1=Double.parseDouble(edtNum1.getText().toString());
        double num2=Double.parseDouble(edtNum2.getText().toString());
        double num3=num1+num2;
        TextView tvResult =getActivity().findViewById(R.id.tvResult);
        tvResult.setText(String.format("%.2f+%.2f=%.2f",num1,num2,num3));
    }
}
