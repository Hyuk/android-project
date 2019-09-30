package com.example.tablayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdopter extends FragmentStatePagerAdapter {

    private int tabCount;

    public PagerAdopter(FragmentManager fragmentManager, int tabCount) {
        super(fragmentManager);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: {
                FragmentOne fragmentOne = new FragmentOne();
                return fragmentOne;
            }
            case 1: {
                FragmentTwo fragmentTwo = new FragmentTwo();
                return fragmentTwo;
            }
            case 2: {
                FragmentThree fragmentThree = new FragmentThree();
                return fragmentThree;
            }
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
