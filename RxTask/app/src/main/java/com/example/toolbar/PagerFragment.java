package com.example.toolbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class PagerFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pager, null);
        viewPager = view.findViewById(R.id.pager);
        pagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager());
        ((MyFragmentPagerAdapter) pagerAdapter).addFragment(PageFragment.newInstance(1));
        ((MyFragmentPagerAdapter) pagerAdapter).addFragment(PageFragment.newInstance(2));
        ((MyFragmentPagerAdapter) pagerAdapter).addFragment(PageFragment.newInstance(3));
        viewPager.setAdapter(pagerAdapter);
        tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return "Fragment " + position;
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }
    }
}