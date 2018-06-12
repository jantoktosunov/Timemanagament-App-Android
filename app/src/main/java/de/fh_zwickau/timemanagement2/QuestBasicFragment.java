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
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View questBasicView = inflater.inflate(R.layout.fragment_quest_basic, container, false);
        createFragments();
        addFragments();
        showFragment(0);
        return questBasicView;
    }
    private void createFragments() {
        QuestStartFragment questStartFragment = QuestStartFragment.newInstance(this);
        String textQuestion_1 = getContext().getString(R.string.quest_1);
        String textQuestion_2 = getContext().getString(R.string.quest_2);
        QuestionFragment firstQuestion = QuestionFragment.newInstance(textQuestion_1, 1, true, this);
        QuestionFragment secondQuestion = QuestionFragment.newInstance(textQuestion_2, 2, false, this);
        fragments.add(0, questStartFragment);
        fragments.add(1, firstQuestion);
        fragments.add(2, secondQuestion);
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

    public void sendAnswer(double answer) {
        overallScore += answer;
    }
    public int getNumberOfQuestions() {
        return fragments.size() - 1;
    }
    public double calculateFinalScore() {
        double finalScore = overallScore / (getNumberOfQuestions() - 1);
        return finalScore;
    }
    public void addEndFragment(QuestEndFragment questEndFragment) {
        fragments.add(questEndFragment);
        getChildFragmentManager().beginTransaction().add(R.id.frag_cont_quest, questEndFragment).commit();
    }
}
