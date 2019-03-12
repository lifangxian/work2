package com.example.www.lifangxain20190308.adapater;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class TabAdapater extends FragmentPagerAdapter {
    private ArrayList<Fragment> list1;
    private ArrayList<String> list2;

    public TabAdapater(FragmentManager fm, ArrayList<Fragment> list1, ArrayList<String> list2) {
        super(fm);
        this.list1 = list1;
        this.list2 = list2;
    }

    @Override
    public Fragment getItem(int i) {
        return list1.get(i);
    }

    @Override
    public int getCount() {
        return list1.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list2.get(position);
    }
}
