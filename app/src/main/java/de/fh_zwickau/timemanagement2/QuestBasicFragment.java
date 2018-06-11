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


public class QuestBasicFragment extends Fragment implements Serializable {
    private QuestStartFragment questStartFragment;
    private QuestionFragment questionFragment;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        questStartFragment = QuestStartFragment.newInstance(this);
        questionFragment = QuestionFragment.newInstance("AAAAA", new QuestionFragment(), true);
        final View questView = inflater.inflate(R.layout.fragment_quest_basic, container, false);
        FragmentManager fragmentManager = getChildFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.frag_cont_quest, questStartFragment)
                .commit();
        getChildFragmentManager().beginTransaction().add(R.id.frag_cont_quest, new QuestionFragment());
        getChildFragmentManager().beginTransaction().hide(questionFragment).commit();
        getChildFragmentManager().beginTransaction().show(questStartFragment).commit();
        return questView;
    }
    public void showFragment() {
        getChildFragmentManager().beginTransaction().show(questionFragment).commit();
        getChildFragmentManager().beginTransaction().hide(questStartFragment).commit();
    }
}
