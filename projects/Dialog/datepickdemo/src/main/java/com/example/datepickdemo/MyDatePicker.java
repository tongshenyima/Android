package com.example.datepickdemo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDatePicker extends DialogFragment {
    public interface OnDateSetListener {
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth);
    }

    OnDateSetListener listener;//谁能最后处理结果（处理结果的对象）

    public MyDatePicker(OnDateSetListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        DatePickerDialog dpd = new DatePickerDialog(getActivity());
        dpd.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                listener.onDateSet(view, year, month, dayOfMonth);
            }
        });
        return dpd;
    }
}
