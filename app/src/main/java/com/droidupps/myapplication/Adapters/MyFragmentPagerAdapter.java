package com.droidupps.myapplication.Adapters;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by shahar ben hayun on 8/26/2016.
 */
public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> mFragments;
    AppCompatActivity activity;

    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments, AppCompatActivity activity) {
        super(fm);
        mFragments = fragments;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }


    @Override
    public float getPageWidth(int position) {
        return 1f;
    }

}

