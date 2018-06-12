package de.fh_zwickau.timemanagement2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

public class QuestEndFragment extends Fragment {
    private static final String QUEST_BASIC_FRAGMENT_KEY = "quest_basic_fragment_key";
    private View questEndView;
    public static QuestEndFragment newInstance(QuestBasicFragment questBasicFragment) {
        QuestEndFragment questEndFragment = new QuestEndFragment();
        Bundle args = new Bundle();
        args.putSerializable(QUEST_BASIC_FRAGMENT_KEY, questBasicFragment);
        questEndFragment.setArguments(args);
        return questEndFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        questEndView = inflater.inflate(R.layout.fragment_quest_end, container, false);
        QuestBasicFragment questBasicFragment =
                (QuestBasicFragment) getArguments().getSerializable(QUEST_BASIC_FRAGMENT_KEY);
        TextView scoreView = questEndView.findViewById(R.id.txt_quest_end_final_score);
        double finalScore = questBasicFragment.calculateFinalScore();
        String scoreString;
        if (finalScore % finalScore == 0) {
            scoreString = String.format("%.0f", finalScore);
        } else {
            scoreString = String.format("%.2f", finalScore);
        }
        scoreView.setText(scoreString + "%");
        return questEndView;
    }

}
