package com.shtoone.shtw.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shtoone.shtw.fragment.messageactivity.MessageActivityViewPagerFragment;

/**
 * Created by leguang on 2016/6/9 0009.
 */
public class MessageActivityViewPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = MessageActivityViewPagerAdapter.class.getSimpleName();
    private String[] title = {"试验室", "拌合站", "施工现场"};

    public MessageActivityViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return MessageActivityViewPagerFragment.newInstance();
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
