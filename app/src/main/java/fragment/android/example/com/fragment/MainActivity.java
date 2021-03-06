package fragment.android.example.com.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    public ViewPager viewPager;
    public TextView tab1,tab2,tab3,tab4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager =  findViewById(R.id.viewpager_id);
        setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tablayout_id);
        tabLayout.setupWithViewPager(viewPager);

        @SuppressLint("InflateParams") View headerView = ((LayoutInflater) Objects.requireNonNull(getSystemService(Context.LAYOUT_INFLATER_SERVICE)))
                .inflate(R.layout.custom_tab, null, false);

         tab1 = headerView.findViewById(R.id.tab1);
         tab2 = headerView.findViewById(R.id.tab2);
         tab3 = headerView.findViewById(R.id.tab3);
         tab4 = headerView.findViewById(R.id.tab4);



        tabLayout.getTabAt(0).setCustomView(tab1);
        tabLayout.getTabAt(1).setCustomView(tab2);
        tabLayout.getTabAt(2).setCustomView(tab3);
        tabLayout.getTabAt(3).setCustomView(tab4);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setElevation(0);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new UnoFragment(), "UNO");
        adapter.addFragment(new DueFragment(), "DUE");
        adapter.addFragment(new TreFragment(), "TRE");
        adapter.addFragment(new QuattroFragment(), "QUATTRO");
        viewPager.setAdapter(adapter);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
