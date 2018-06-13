package de.fh_zwickau.timemanagement2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeContainerFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_container, container, false);
        HomeFragment homeFragment = new HomeFragment();
        getChildFragmentManager().beginTransaction().add(R.id.home_frag_cont, homeFragment).commit();
        getChildFragmentManager().beginTransaction().show(homeFragment).commit();
        return view;
        // return super.onCreateView(R.layout.fragment_home_container, container, savedInstanceState);
    }
}
