package de.fh_zwickau.timemanagement2;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class QuestionFragment extends Fragment implements Serializable {

    public static QuestionFragment newInstance(String questText, QuestionFragment nextFragment, boolean type) {
        QuestionFragment questionFragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putString("quesText", questText);
        args.putSerializable("nextFragment", nextFragment);
        args.putBoolean("type", type);
        questionFragment.setArguments(args);
        return questionFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View questView = inflater.inflate(R.layout.fragment_quest_1, container, false);
        TextView headerTxtView = questView.findViewById(R.id.quest1_txt_header);
        headerTxtView.setText("Question 1/18");
        TextView questTxtView = questView.findViewById(R.id.quest1_txt);
        //questTxtView.setText(getArguments().getString("questText"));
        questTxtView.setText("Whaaat?");
        ImageView imgView = questView.findViewById(R.id.imgViewNext1);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return questView;
    }
}
