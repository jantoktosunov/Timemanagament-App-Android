package de.fh_zwickau.timemanagement2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class HomeFragment extends Fragment {
    //private static final Task[] tasks = {new Task("DO IT"), new Task("DO IT LATER!"),
     //                                 new Task("Write text"), new Task("Find this")};

    //    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Spinner spinner = getView().findViewById(R.id.taskSpinner);
//        //ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(getActivity(), R.layout.support_simple_spinner_dropdown_item, R.array.task_arts_array);
//    }

    ArrayList<Task> tasks;
    ListView listView;
    private static TaskAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        String[] taskStrings = {"1","2","3","4"};
        listView = view.findViewById(R.id.list_tasks);
        tasks = new ArrayList<>();
        tasks.add(new Task("DRWG",new Date(),Urgency.DRWG));
        tasks.add(new Task("DRWG",new Date(),Urgency.DRWG));
        tasks.add(new Task("NDRWG",new Date(),Urgency.NDRWG));
        tasks.add(new Task("NDRNWG",new Date(),Urgency.NDRNWG));
        tasks.add(new Task("DRNWG",new Date(),Urgency.DRNWG));
        tasks.add(new Task("DRNWGDRNWGDRNWGDRNWG" +
                "DRNWGDRNWGDRNWGDRNWGDRNWGDRNWGDRNWGDRNWG" +
                "DRNWGDRNWGDRNWGDRNWG" +
                "DRNWGDRNWGDRNWGDRNWGDRNWG" +
                "DRNWGDRNWGDRNWGDRNWGDRNWG" +
                "DRNWGDRNWGDRNWGDRNWGDRNWG" +
                "DRNWGDRNWGDRNWGDRNWGDRNWG",new Date(),Urgency.DRNWG));
        tasks.add(new Task("DRWG",new Date(),Urgency.DRWG));
        tasks.add(new Task("DRWG",new Date(),Urgency.DRWG));
        tasks.add(new Task("NDRWG",new Date(),Urgency.NDRWG));
        tasks.add(new Task("NDRNWG",new Date(),Urgency.NDRNWG));
        tasks.add(new Task("DRNWG",new Date(),Urgency.DRNWG));
        tasks.add(new Task("DRWG",new Date(),Urgency.DRWG));
        tasks.add(new Task("DRWG",new Date(),Urgency.DRWG));
        tasks.add(new Task("DRWG",new Date(),Urgency.DRWG));
        tasks.add(new Task("DRWG",new Date(),Urgency.DRWG));



        adapter = new TaskAdapter(tasks, getActivity().getApplicationContext());
        listView.setAdapter(adapter);
        //listView.setAdapter(new ArrayAdapter<Task>(getActivity(), android.R.layout.simple_list_item_1, tasks));

        return view;

    }
}
