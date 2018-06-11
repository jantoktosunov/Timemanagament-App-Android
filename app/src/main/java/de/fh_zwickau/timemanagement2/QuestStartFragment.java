package de.fh_zwickau.timemanagement2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class QuestStartFragment extends Fragment {
    public static QuestStartFragment newInstance(QuestBasicFragment questBasicFragment) {
        QuestStartFragment questStartFragment = new QuestStartFragment();
        Bundle args = new Bundle();
        args.putSerializable("A", questBasicFragment);
        questStartFragment.setArguments(args);
        return questStartFragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View questView = inflater.inflate(R.layout.fragment_quest_start, container, false);
        ImageView nextImg = questView.findViewById(R.id.nexyImgView);
        nextImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                QuestionFragment questionFragment =
//                        QuestionFragment.newInstance("What?", new QuestionFragment(), true);
//                getChildFragmentManager()
//                        .beginTransaction()
//                        .add(R.id.frag_cont_quest, questionFragment)
//                        .commit();
//                getChildFragmentManager().beginTransaction().show(questionFragment);
                //getChildFragmentManager().beginTransaction().hide()
                QuestBasicFragment questBasicFragment = (QuestBasicFragment) getArguments().getSerializable("A");
                questBasicFragment.showFragment();
            }
        });
        return questView;
    }
    private void createQuestions() {
        /*
        *   String quest1String = "Do you now da wey?";
        *   String quest2String = "How are you?";
        *   QuestionFragment fragmentFirst = new QuestionFragment(quest1String, nextFragment, type);
        *
        *   QuestionFragment nextFragment = QuestionFragment(quest2String, "last", type);
        *
        * */
    }
}
