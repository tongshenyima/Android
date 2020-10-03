package net.jxvtc.task005;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;


/**
 * A simple {@link Fragment} subclass.
 */
public class SetDateFragment extends DialogFragment {
public interface TransferListener{
    void transfer(int year, int month, int day);
}
TransferListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        DatePickerDialog dpd=new DatePickerDialog(getContext());
        dpd.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                if (listener!=null)
                    listener.transfer(year,month,dayOfMonth);

            }
        });
        return dpd;
    }


}
