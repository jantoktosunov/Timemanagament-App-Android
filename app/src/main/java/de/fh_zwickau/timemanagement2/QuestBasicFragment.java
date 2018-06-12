package de.fh_zwickau.timemanagement2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.ArrayList;


public class QuestBasicFragment extends Fragment implements Serializable {
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private double overallScore;
    private double shortRangeScore;
    private double attitudesScore;
    private double longRangeScore;

    private double shortRangeNumber;
    private double attitudesNumber;
    private double longRangeNumber;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View questBasicView = inflater.inflate(R.layout.fragment_quest_basic, container, false);
        shortRangeScore = 0;
        attitudesNumber = 0;
        longRangeNumber = 0;
        createFragments();
        addFragments();
        showFragment(0);
        return questBasicView;
    }
    private void createFragments() {
        QuestStartFragment questStartFragment = QuestStartFragment.newInstance(this);
        String textQuestion_1 = getContext().getString(R.string.quest_1);
        String textQuestion_2 = getContext().getString(R.string.quest_2);
        String textQuestion_3 = getContext().getString(R.string.quest_3);
        String textQuestion_4 = getContext().getString(R.string.quest_4);
        String textQuestion_5 = getContext().getString(R.string.quest_5);

        QuestionFragment questionFgt_1 = QuestionFragment
                .newInstance(textQuestion_1, 1, true, QuestionType.SHORT_RANGE_PLANNING, this);
        QuestionFragment questionFgt_2 = QuestionFragment
                .newInstance(textQuestion_2, 2, true, QuestionType.TIME_ATTITUDES,this);
        QuestionFragment questionFgt_3 = QuestionFragment
                .newInstance(textQuestion_3, 3, true, QuestionType.LONG_RANGE_PLANNING, this);

        fragments.add(0, questStartFragment);
        fragments.add(1, questionFgt_1);
        fragments.add(2, questionFgt_2);
        fragments.add(3, questionFgt_3);
    }
    public void showFragment(int position) {
        FragmentManager fragmentManager = getChildFragmentManager();
        for (int i = 0; i < fragments.size(); i++) {
            if (i == position) {
                fragmentManager.beginTransaction().show(fragments.get(i)).commit();
            } else {
                fragmentManager.beginTransaction().hide(fragments.get(i)).commit();
            }
        }
    }

    private void addFragments() {
        FragmentManager fragmentManager = getChildFragmentManager();
        for (Fragment fragment: fragments) {
            fragmentManager.beginTransaction().add(R.id.frag_cont_quest, fragment).commit();
        }
    }

    public void sendAnswer(double answer, QuestionType type) {
        overallScore += answer;
        if (type == QuestionType.SHORT_RANGE_PLANNING) {
            shortRangeScore += answer;
        } else if (type == QuestionType.TIME_ATTITUDES) {
            attitudesScore += answer;
        } else if (type == QuestionType.LONG_RANGE_PLANNING) {
            longRangeScore += answer;
        }
    }

    public int getNumberOfQuestions() {
        return fragments.size() - 1;
    }
    public double calculateFinalScore() {
        double finalScore = overallScore / (getNumberOfQuestions() - 1);
        return finalScore;
    }
    public double calculateTypeFinalScore(QuestionType type) {
        double finalScore = 0;
        if (type == QuestionType.SHORT_RANGE_PLANNING) {
            finalScore = shortRangeScore / shortRangeNumber;
        } else if (type == QuestionType.TIME_ATTITUDES) {
            finalScore = attitudesScore / attitudesNumber;
        } else if (type == QuestionType.LONG_RANGE_PLANNING) {
            finalScore = longRangeScore / longRangeNumber;
        }
        return finalScore;
    }
    public void addEndFragment(QuestEndFragment questEndFragment) {
        fragments.add(questEndFragment);
        getChildFragmentManager().beginTransaction().add(R.id.frag_cont_quest, questEndFragment).commit();
    }
    public void addTypeNumber(QuestionType type) {
        if (type == QuestionType.SHORT_RANGE_PLANNING) {
            shortRangeNumber++;
        } else if (type == QuestionType.TIME_ATTITUDES) {
            attitudesNumber++;
        } else if (type == QuestionType.LONG_RANGE_PLANNING) {
            longRangeNumber++;
        }
    }
    public void reset() {
        overallScore = 0;
        shortRangeNumber = 0;
        shortRangeScore = 0;
        attitudesNumber = 0;
        attitudesScore = 0;
        longRangeNumber = 0;
        longRangeScore = 0;
    }
    public void removeEndFragment(QuestEndFragment endFragment) {
        fragments.remove(endFragment);
        getChildFragmentManager().beginTransaction().remove(endFragment).commit();
    }

}
