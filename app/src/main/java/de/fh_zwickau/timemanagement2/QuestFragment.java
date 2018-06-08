package de.fh_zwickau.timemanagement2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class QuestFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View questView = inflater.inflate(R.layout.fragment_quest, container, false);
        ImageView nextImg = questView.findViewById(R.id.nexyImgView);
        final TextView headerTxt = questView.findViewById(R.id.quest_txt_header);
        nextImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headerTxt.setText("AAAA");
                LinksFragment linksFragment = new LinksFragment();
                FragmentTransaction fragmentTransaction =
                        getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frag_cont_quest, linksFragment);
                //fragmentTransaction.detach(QuestFragment.this);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return questView;
    }
}
