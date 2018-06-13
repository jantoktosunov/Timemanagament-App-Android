package de.fh_zwickau.timemanagement2;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements Serializable {
    private CustomViewPager viewPager;
    private static final int HOME_POSITION = 0;
    private static final int LINKS_POSITION = 1;
    private static final int ADD_POSITION = 2;
    private static final int QUEST_POSITION = 3;

    private static final String KEY_HOME_FRAGMENT = "home_fragment";
    private static final String KEY_LINKS_FRAGMENT = "links_fragment";
    private static final String KEY_ADD_FRAGMENT = "add_fragment";
    private static final String KEY_QUEST_FRAGMENT = "quest_fragment";
    private ArrayList<Fragment> fragments = new ArrayList<>();

    private ArrayList<Task> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        //fragments.add(new HomeFragment());
        fragments.add(HomeContainerFragment.newInstance(this));
        fragments.add(new LinksFragment());
        fragments.add(new AddFragment());
        fragments.add(new QuestBasicFragment());
        initFragments();
        showFragment(HOME_POSITION);
        createTasks();
//        viewPager = (CustomViewPager) findViewById(R.id.viewPager);
//        ViewPagerAdapter adapter = new ViewPagerAdapter(MainActivity.this.getSupportFragmentManager());
//        adapter.addFragment(new HomeFragment(), "homeFragment");
//        adapter.addFragment(new LinksFragment(), "linksFragment");
//        adapter.addFragment(new AddFragment(), "addFragment");
//        adapter.addFragment(new QuestBasicFragment(), "questFragment");
//        viewPager.setAdapter(adapter);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            showFragment(HOME_POSITION);
                            break;
                        case R.id.nav_links:
                            showFragment(LINKS_POSITION);
                            break;
                        case  R.id.nav_add:
                            showFragment(ADD_POSITION);
                            break;
                        case  R.id.nav_quest:
                            showFragment(QUEST_POSITION);
                            break;
                    }
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                            selectedFragment).addToBackStack(null).commit();
//                    switch (item.getItemId()) {
//                        case R.id.nav_home:
//                            viewPager.setCurrentItem(0);
//                            break;
//                        case R.id.nav_links:
//                            viewPager.setCurrentItem(1);
//                            break;
//                        case R.id.nav_add:
//                            viewPager.setCurrentItem(2);
//                            break;
//                        case R.id.nav_quest:
//                            viewPager.setCurrentItem(3);
//                            break;
//
//                    }
//                    return true;
                    return true;
                }
            };
    private void initFragments() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getFragments().isEmpty()) {
            for (Fragment fragment: fragments) {
                fragmentManager.beginTransaction()
                        .add(R.id.fragment_container, fragment)
                        .commit();
            }
        }
    }
    private void showFragment(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        for (int i = 0; i < fragments.size(); i++) {
            if (i == position) {
                fragmentManager.beginTransaction().show(fragments.get(i)).commit();
            } else {
                fragmentManager.beginTransaction().hide(fragments.get(i)).commit();
            }
        }
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
    public void addTask(Task task){
        tasks.add(task);
    }
    private void createTasks() {
        tasks.add(new Task("TRUE",new Date(),Urgency.DRWG));
        tasks.add(new Task("TRUE",new Date(),Urgency.DRWG));
        tasks.add(new Task("TRUE",new Date(),Urgency.NDRWG));
        tasks.add(new Task("1",new Date(),Urgency.NDRNWG));
        tasks.add(new Task("2",new Date(),Urgency.NDRNWG));
        tasks.add(new Task("3",new Date(),Urgency.NDRNWG));
        tasks.add(new Task("4",new Date(),Urgency.NDRNWG));
        tasks.add(new Task("5",new Date(),Urgency.DRNWG));
    }
}

