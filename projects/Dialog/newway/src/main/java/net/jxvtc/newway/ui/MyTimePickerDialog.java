package net.jxvtc.newway.ui;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyTimePickerDialog extends DialogFragment {
    public interface TimerDialogListener {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) ;

    }
    TimerDialogListener listener;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
       TimePickerDialog dpd =new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
           @Override
           public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
               listener.onTimeSet(view,hourOfDay,minute);
           }
       },20,12,true);
        return dpd;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = (TimerDialogListener) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException( " must implement DateDialogListener");
        }
    }
}
