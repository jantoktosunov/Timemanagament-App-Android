package de.fh_zwickau.timemanagement2;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AddFragment extends Fragment implements Serializable, DatePickerDialog.OnDateSetListener {

    private static final String MAIN_ACTIVITY_KEY = "de.fh_zwickau.mainApp_key";
    private MainActivity mainActivity;
    private ImageView doneImg;
    private TextView taskText;
    private ImageView dateImg;
    private TextView dateText;
    private Date taskDate;
    public static AddFragment newInstance(MainActivity mainActivity) {
        AddFragment addFragment = new AddFragment();
        Bundle args = new Bundle();
        args.putSerializable(MAIN_ACTIVITY_KEY, mainActivity);
        addFragment.setArguments(args);
        return addFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        mainActivity = (MainActivity) getArguments().getSerializable(MAIN_ACTIVITY_KEY);
        mainActivity.addTask(new Task("111", new Date(),Urgency.DRWG));
        taskText = view.findViewById(R.id.add_txt_text);
        dateText = view.findViewById(R.id.add_txt_date);
        doneImg = view.findViewById(R.id.add_img_done);
        doneImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = getTaskText().getText().toString();

                mainActivity.addTask(new Task(text, taskDate, Urgency.DRWG));

                //TODO Transition from AddFragment to HomeFragment OR?

            }
        });
        dateImg = view.findViewById(R.id.add_img_calendar);
        dateImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = SelectDateFragment.newInstance(AddFragment.this);
                datePicker.show(getActivity().getFragmentManager(), "date_picker");
            }
        });
        return view;
    }

    public TextView getTaskText() {
        return taskText;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        taskDate = calendar.getTime();
        String mon = calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault());
        dateText.setText(dayOfMonth + " " + mon);
    }
}
