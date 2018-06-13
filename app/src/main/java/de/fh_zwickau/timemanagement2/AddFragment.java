package de.fh_zwickau.timemanagement2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Date;

public class AddFragment extends Fragment {

    private static final String MAIN_ACTIVITY_KEY = "de.fh_zwickau.mainApp_key";
    private MainActivity mainActivity;
    private ImageView doneImg;
    private TextView taskText;
    private int rand;
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
        //return inflater.inflate(R.layout.fragment_add, container, false);
        taskText = view.findViewById(R.id.add_txt_text);
        //final String text = taskText.getText().toString();
        doneImg = view.findViewById(R.id.add_img_done);
        doneImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = getTaskText().getText().toString();

                mainActivity.addTask(new Task(text, new Date(), Urgency.DRWG));

                //TODO Transition from AddFragment to HomeFragment OR?

            }
        });
        return view;
    }

    public TextView getTaskText() {
        return taskText;
    }
}
