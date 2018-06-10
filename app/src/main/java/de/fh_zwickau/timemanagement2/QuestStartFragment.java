package de.fh_zwickau.timemanagement2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class QuestStartFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View questView = inflater.inflate(R.layout.fragment_quest_start, container, false);
        ImageView nextImg = questView.findViewById(R.id.nexyImgView);
        final TextView headerTxt = questView.findViewById(R.id.quest_txt_header);
        nextImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


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
