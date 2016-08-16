package com.shtoone.shtw.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shtoone.shtw.fragment.aboutactivity.AboutActivityViewPagerFragment;

/**
 * Created by leguang on 2016/6/9 0009.
 */
public class AboutActivityViewPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = AboutActivityViewPagerAdapter.class.getSimpleName();
    private String[] title = {"关于APP", "关于我们"};

    public AboutActivityViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (null != title && title.length > 0) {
            return AboutActivityViewPagerFragment.newInstance(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        if (null != title && title.length > 0) {
            return title.length;
        }
        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (null != title && title.length > 0) {
            return title[position];
        }
        return null;
    }
}
