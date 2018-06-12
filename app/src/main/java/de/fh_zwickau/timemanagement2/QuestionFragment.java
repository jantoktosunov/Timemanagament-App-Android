package de.fh_zwickau.timemanagement2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.Serializable;

public class QuestionFragment extends Fragment implements Serializable {
    private static final String QUESTION_TEXT_KEY = "de.fh-zwickau.question_text_key";
    private static final String POSITION_KEY = "de.fh-zwickau.position_key";
    private static final String NORMAL_SCORED_KEY = "de.fh-zwickau.normal_scored_key";
    private static final String BASIC_FRAGMENT_KEY = "de.fh-zwickau.basic_fragment_key";

    public static QuestionFragment newInstance(String questionText, int position, boolean normalScored, QuestBasicFragment basicFragment) {
        QuestionFragment questionFragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putString(QUESTION_TEXT_KEY, questionText);
        args.putInt(POSITION_KEY, position);
        args.putBoolean(NORMAL_SCORED_KEY, normalScored);
        args.putSerializable(BASIC_FRAGMENT_KEY, basicFragment);
        questionFragment.setArguments(args);
        return questionFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View questView = inflater.inflate(R.layout.fragment_quest_1, container, false);
        final QuestBasicFragment questBasicFragment =
                (QuestBasicFragment) getArguments().getSerializable(BASIC_FRAGMENT_KEY);
        final int position = getArguments().getInt(POSITION_KEY);
        boolean normalScored = getArguments().getBoolean(NORMAL_SCORED_KEY);
        if (!normalScored) {
            RadioButton button_1 = questView.findViewById(R.id.radioButton_1);
            RadioButton button_2 = questView.findViewById(R.id.radioButton_2);
            RadioButton button_4 = questView.findViewById(R.id.radioButton_4);
            RadioButton button_5 = questView.findViewById(R.id.radioButton_5);
            String btn_1_text = button_1.getText().toString();
            String btn_2_text = button_2.getText().toString();
            String btn_4_text = button_4.getText().toString();
            String btn_5_text = button_5.getText().toString();
            button_1.setText(btn_5_text);
            button_2.setText(btn_4_text);
            button_4.setText(btn_2_text);
            button_5.setText(btn_1_text);
        }
        final TextView headerTxtView = questView.findViewById(R.id.quest1_txt_header);
        headerTxtView.setText("Question " + position + "/" + questBasicFragment.getNumberOfQuestions());
        TextView questTxtView = questView.findViewById(R.id.quest1_txt);
        questTxtView.setText(getArguments().getString(QUESTION_TEXT_KEY));
        ImageView imgView = questView.findViewById(R.id.imgViewNext1);
        final RadioGroup radioGroup = questView.findViewById(R.id.radio_group_quest);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == R.id.radioButton_1) {
                    questBasicFragment.sendAnswer(20);
                } else if (selectedId == R.id.radioButton_2) {
                    questBasicFragment.sendAnswer(40);
                } else if (selectedId == R.id.radioButton_3) {
                    questBasicFragment.sendAnswer(60);
                } else if (selectedId == R.id.radioButton_4) {
                    questBasicFragment.sendAnswer(80);
                } else if (selectedId == R.id.radioButton_5) {
                    questBasicFragment.sendAnswer(100);
                }
                if (position == questBasicFragment.getNumberOfQuestions()) {
                    QuestEndFragment questEndFragment = QuestEndFragment.newInstance(questBasicFragment);
                    questBasicFragment.addEndFragment(questEndFragment);
                }
                questBasicFragment.showFragment(position + 1);
            }
        });

        return questView;
    }
}
