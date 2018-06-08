package de.fh_zwickau.timemanagement2;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private CustomViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        viewPager = (CustomViewPager) findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(MainActivity.this.getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), "homeFragment");
        adapter.addFragment(new LinksFragment(), "linksFragment");
        adapter.addFragment(new AddFragment(), "addFragment");
        adapter.addFragment(new QuestFragment(), "questFragment");
        viewPager.setAdapter(adapter);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    Fragment selectedFragment = null;
//                    switch (item.getItemId()) {
//                        case R.id.nav_home:
//                            selectedFragment = new HomeFragment();
//                            break;
//                        case R.id.nav_links:
//                            selectedFragment = new LinksFragment();
//                            break;
//                        case  R.id.nav_add:
//                            selectedFragment = new AddFragment();
//                            break;
//                        case  R.id.nav_quest:
//                            selectedFragment = new QuestFragment();
//                            break;
//                    }
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                            selectedFragment).addToBackStack(null).commit();
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            viewPager.setCurrentItem(0);
                            break;
                        case R.id.nav_links:
                            viewPager.setCurrentItem(1);
                            break;
                        case R.id.nav_add:
                            viewPager.setCurrentItem(2);
                            break;
                        case R.id.nav_quest:
                            viewPager.setCurrentItem(3);
                            break;

                    }
                    return true;
                }
            };
}

